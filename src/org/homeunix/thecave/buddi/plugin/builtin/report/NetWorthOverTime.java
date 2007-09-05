/*
 * Created on Sep 14, 2006 by wyatt
 */
package org.homeunix.thecave.buddi.plugin.builtin.report;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.homeunix.thecave.buddi.i18n.BuddiKeys;
import org.homeunix.thecave.buddi.i18n.keys.PluginReportDateRangeChoices;
import org.homeunix.thecave.buddi.plugin.api.BuddiReportPlugin;
import org.homeunix.thecave.buddi.plugin.api.model.ImmutableAccount;
import org.homeunix.thecave.buddi.plugin.api.model.ImmutableDocument;
import org.homeunix.thecave.buddi.plugin.api.util.HtmlHelper;
import org.homeunix.thecave.buddi.plugin.api.util.HtmlPage;
import org.homeunix.thecave.buddi.plugin.api.util.TextFormatter;
import org.homeunix.thecave.moss.util.DateFunctions;
import org.homeunix.thecave.moss.util.Formatter;
import org.homeunix.thecave.moss.util.Log;
import org.homeunix.thecave.moss.util.Version;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class NetWorthOverTime extends BuddiReportPlugin {

	public static final long serialVersionUID = 0;

	@Override
	public HtmlPage getReport(ImmutableDocument model, Date startDate, Date endDate) {
		final int NUM_SAMPLES = 12;

		DefaultCategoryDataset barData = new DefaultCategoryDataset();

		List<Date> dates = new LinkedList<Date>();
		Date date = startDate;

		int numberOfDaysBetween = DateFunctions.getDaysBetween(startDate, new Date(), false);
		int daysBetweenReport = numberOfDaysBetween / NUM_SAMPLES;

		for (int i = 0; i < NUM_SAMPLES; i++){
			date = DateFunctions.addDays(startDate, i * daysBetweenReport);
			if (date.before(new Date()))
				dates.add(date);
			Log.debug("Added date: " + date);			
		}

		dates.add(new Date());

		List<ImmutableAccount> accounts = model.getImmutableAccounts();
		for (Date d : dates) {
			long total = 0; 
			for (ImmutableAccount a : accounts) {
				total += a.getBalance(d);
			}

//			barData.addValue((Number) new Double(accounts.get(a) / 100.0), TextFormatter.getFormattedDate(d), a.getName());
			barData.addValue((Number) new Double(total / 100.0), 
					TextFormatter.getTranslation(BuddiKeys.NET_WORTH), 
					(Formatter.getDateFormat("MM/dd").format(d)));
		}



		JFreeChart chart = ChartFactory.createLineChart(
				"", //Title
				"", //Domain axis label
				"", //Range axis label
				barData,             // data
				PlotOrientation.VERTICAL,
				true,               // include legend
				true,
				false
		);

		chart.setBackgroundPaint(Color.WHITE);
		chart.setBorderStroke(new BasicStroke(0));

		StringBuilder sb = HtmlHelper.getHtmlHeader(
				TextFormatter.getTranslation(BuddiKeys.GRAPH_TITLE_NET_WORTH_OVER_TIME), 
				null, 
				startDate, 
				endDate);

		sb.append("<img class='center_img' src='graph.png' />");
		sb.append(HtmlHelper.getHtmlFooter());

		Map<String, BufferedImage> images = new HashMap<String, BufferedImage>();
		images.put("graph.png", 
				chart.createBufferedImage(
						Math.min(Toolkit.getDefaultToolkit().getScreenSize().width - 200, 1000),
						Toolkit.getDefaultToolkit().getScreenSize().height - 100));

		return new HtmlPage(sb.toString(), images);
	}

	public String getName() {
		return BuddiKeys.GRAPH_TITLE_NET_WORTH_OVER_TIME.toString();
	}

	@Override
	public PluginReportDateRangeChoices getDateRangeChoice() {
		return PluginReportDateRangeChoices.START_ONLY;
	}

	public String getDescription() {
		return BuddiKeys.NETWORTH_LINE_GRAPH.toString();
	}

	public boolean isPluginActive() {
		return true;
	}

	public Version getMaximumVersion() {
		return null;
	}

	public Version getMinimumVersion() {
		return null;
	}
}
