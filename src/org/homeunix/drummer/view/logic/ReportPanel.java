/*
 * Created on May 6, 2006 by wyatt
 */
package org.homeunix.drummer.view.logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import javax.swing.JComboBox;

import org.homeunix.drummer.Strings;
import org.homeunix.drummer.controller.DataInstance;
import org.homeunix.drummer.util.DateUtil;
import org.homeunix.drummer.view.AbstractBudgetPanel;
import org.homeunix.drummer.view.layout.ReportPanelLayout;
import org.homeunix.drummer.view.reports.logic.CustomDateIntervalDialog;
import org.homeunix.drummer.view.reports.logic.CustomEndDateDialog;
import org.homeunix.drummer.view.reports.logic.CustomStartDateDialog;
import org.homeunix.drummer.view.reports.logic.ExpenseBudgetedActualGraphFrame;
import org.homeunix.drummer.view.reports.logic.ExpensesGraphFrame;
import org.homeunix.drummer.view.reports.logic.IncomeExpenseReportFrame;
import org.homeunix.drummer.view.reports.logic.IncomeGraphFrame;
import org.homeunix.drummer.view.reports.logic.NetWorthGraphFrame;
import org.homeunix.drummer.view.reports.logic.NetWorthOverTimeGraphFrame;

public class ReportPanel extends ReportPanelLayout {
	public static final long serialVersionUID = 0;
		
	public ReportPanel(){
		super();
	}
	
	protected AbstractBudgetPanel initActions(){
		for (JComboBox box : jComboBoxes.keySet()) {
			box.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {
					if (arg0.getSource() != null){
						if (arg0.getSource() instanceof JComboBox) {
							JComboBox box = (JComboBox) arg0.getSource();
							if (box.getSelectedItem() instanceof DateChoice) {
								DateChoice choice = (DateChoice) box.getSelectedItem();
								if (jComboBoxes.get(box) instanceof ReportType) {
									ReportType type = (ReportType) jComboBoxes.get(box);
									if (choice.isCustom()){
										if (type.equals(ReportType.REVENUE_EXPENSE)
												|| type.equals(ReportType.INCOME_EXPENSE)
												|| type.equals(ReportType.EXPENSES)
												|| type.equals(ReportType.INCOME))
											new CustomDateIntervalDialog(
													MainBudgetFrame.getInstance(),
													type
											).openWindow();
										else if (type.equals(ReportType.NETWORTH_OVER_TIME))
											new CustomStartDateDialog(
													MainBudgetFrame.getInstance(),
													type
											).openWindow();
										else if (type.equals(ReportType.NETWORTH))
											new CustomEndDateDialog(
													MainBudgetFrame.getInstance(),
													type
											).openWindow();

											
									}
									else{
										//[TODO] Add more report / graph types here as needed.
										if (type.equals(ReportType.EXPENSES))
											new ExpensesGraphFrame(choice.getStartDate(), choice.getEndDate());
										else if (type.equals(ReportType.INCOME))
											new IncomeGraphFrame(choice.getStartDate(), choice.getEndDate());
										else if(type.equals(ReportType.NETWORTH))
											new NetWorthGraphFrame(choice.getEndDate());
										else if(type.equals(ReportType.REVENUE_EXPENSE))
											new ExpenseBudgetedActualGraphFrame(choice.getStartDate(), choice.getEndDate());
										else if(type.equals(ReportType.NETWORTH_OVER_TIME))
											new NetWorthOverTimeGraphFrame(choice.getStartDate());
										else if(type.equals(ReportType.INCOME_EXPENSE))
											new IncomeExpenseReportFrame(choice.getStartDate(), choice.getEndDate());
									}
								}
							}
							box.setSelectedItem(null);
						}
					}
				}
			});
		}
		return this;
	}
	
	protected AbstractBudgetPanel initContent(){
		DataInstance.getInstance().calculateAllBalances();
		
		return this;
	}
	
	public AbstractBudgetPanel updateContent(){

		return this;
	}

	@Override
	protected Vector<DateChoice> getIntervals() {
		Vector<DateChoice> intervals = new Vector<DateChoice>();
		
		intervals.add(null);
		intervals.add(new DateChoice(
				DateUtil.getBeginOfMonth(DateUtil.getStartDate(new Date()), 0),
				DateUtil.getEndOfMonth(DateUtil.getEndDate(new Date()), 0),
				Strings.inst().get(Strings.THIS_MONTH)
		));
		intervals.add(new DateChoice(
				DateUtil.getBeginOfMonth(DateUtil.getStartDate(new Date()), -1),
				DateUtil.getEndOfMonth(DateUtil.getEndDate(new Date()), -1),
				Strings.inst().get(Strings.LAST_MONTH)
		));
		intervals.add(new DateChoice(
				DateUtil.getBeginOfYear(Calendar.getInstance().get(Calendar.YEAR)),
				DateUtil.getEndOfYear(Calendar.getInstance().get(Calendar.YEAR)),
				Strings.inst().get(Strings.THIS_YEAR)
		));
		
		intervals.add(new DateChoice(
				DateUtil.getBeginOfYear(Calendar.getInstance().get(Calendar.YEAR) - 1),
				DateUtil.getEndOfYear(Calendar.getInstance().get(Calendar.YEAR) - 1),
				Strings.inst().get(Strings.LAST_YEAR)
		));
		intervals.add(new DateChoice(
				Strings.inst().get(Strings.OTHER)
		));
		
		return intervals;
	}

	@Override
	protected Vector<DateChoice> getEndDates() {
		Vector<DateChoice> endDates = new Vector<DateChoice>();
		
		endDates.add(null);
		endDates.add(new DateChoice(
				null,
				new Date(),
				Strings.inst().get(Strings.TODAY)
		));
		endDates.add(new DateChoice(
				null,
				DateUtil.getNextNDay(new Date(), -1),
				Strings.inst().get(Strings.YESTERDAY)
		));
		endDates.add(new DateChoice(
				null,
				DateUtil.getNextNDay(new Date(), -8),
				Strings.inst().get(Strings.LAST_WEEK)
		));
		endDates.add(new DateChoice(
				null,
				DateUtil.getNextNDay(new Date(), -30),
				Strings.inst().get(Strings.LAST_MONTH)
		));
		endDates.add(new DateChoice(
				null,
				DateUtil.getNextNDay(new Date(), -365),
				Strings.inst().get(Strings.LAST_YEAR)
		));
		endDates.add(new DateChoice(
				Strings.inst().get(Strings.OTHER)
		));
		

		return endDates;
	}

	@Override
	protected Vector<DateChoice> getStartDates() {
		Vector<DateChoice> startDates = new Vector<DateChoice>();

		
		startDates.add(null);
		startDates.add(new DateChoice(
				DateUtil.getNextNDay(new Date(), -30),
				null,
				Strings.inst().get(Strings.ONE_MONTH)
		));
		startDates.add(new DateChoice(
				DateUtil.getNextNDay(new Date(), -60),
				null,
				Strings.inst().get(Strings.TWO_MONTHS)
		));
		startDates.add(new DateChoice(
				DateUtil.getEndOfMonth(DateUtil.getStartDate(new Date()), -6),
				null,
				Strings.inst().get(Strings.SIX_MONTHS)
		));
		
		startDates.add(new DateChoice(
				DateUtil.getEndOfMonth(DateUtil.getStartDate(new Date()), -12),
				null,
				Strings.inst().get(Strings.YEAR)
		));
		
		startDates.add(new DateChoice(
				Strings.inst().get(Strings.OTHER)
		));
		
		return startDates;
	}
	
	
}