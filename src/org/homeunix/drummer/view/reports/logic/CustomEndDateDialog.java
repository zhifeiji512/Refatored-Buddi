/*
 * Created on May 20, 2006 by wyatt
 */
package org.homeunix.drummer.view.reports.logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.homeunix.drummer.Strings;
import org.homeunix.drummer.util.DateUtil;
import org.homeunix.drummer.util.Log;
import org.homeunix.drummer.view.AbstractBudgetDialog;
import org.homeunix.drummer.view.layout.ReportPanelLayout.ReportType;
import org.homeunix.drummer.view.reports.layout.CustomDateDialogLayout;

public class CustomEndDateDialog extends CustomDateDialogLayout {
	public static final long serialVersionUID = 0;
	
	private ReportType reportType;

	public CustomEndDateDialog(JFrame parent, ReportType reportType){
		super(parent);
		
		this.reportType = reportType;
	}
	
	@Override
	protected AbstractBudgetDialog clearContent() {
		return this;
	}

	@Override
	protected AbstractBudgetDialog initActions() {
		okButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				Date endDate;
				if (endDateCombo.getValue() instanceof Date){
					endDate = DateUtil.getEndDate((Date) endDateCombo.getValue());
				}
				else{
					Log.debug("Start and End interval not of type date");
					return;
				}
				
				if (endDate.after(DateUtil.getEndDate(new Date()))){
					JOptionPane.showMessageDialog(
							null, 
							Strings.inst().get(Strings.DATE_AFTER_TODAY), 
							Strings.inst().get(Strings.REPORT_DATE_ERROR), 
							JOptionPane.ERROR_MESSAGE
					);
					return;
				}
				
				if (reportType.equals(ReportType.NETWORTH))
					new NetWorthGraphFrame(endDate);
				else
					Log.debug("Don't know what to do with type " + reportType);
				//[TODO] Add more types as needed...
		
				CustomEndDateDialog.this.setVisible(false);
			}
		});
		
		cancelButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				CustomEndDateDialog.this.setVisible(false);
			}
		});
		
		return this;
	}

	@Override
	protected AbstractBudgetDialog initContent() {
		return this;
	}

	@Override
	public AbstractBudgetDialog updateButtons() {
		return this;
	}

	@Override
	protected AbstractBudgetDialog updateContent() {
		return this;
	}
	
	protected void setVisibility(){
		mainLabel.setText(Strings.inst().get(Strings.REPORT_AS_OF_DATE));
		middleLabel.setVisible(false);
		
		startDateCombo.setVisible(false);
	}
}