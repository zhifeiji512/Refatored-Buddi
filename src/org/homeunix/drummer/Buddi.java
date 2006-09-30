/*
 * Created on Jun 26, 2005 by wyatt
 */
package org.homeunix.drummer;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import net.roydesign.mac.MRJAdapter;

import org.homeunix.drummer.controller.MainBuddiFrame;
import org.homeunix.drummer.controller.Translate;
import org.homeunix.drummer.controller.TranslateKeys;
import org.homeunix.drummer.prefs.PrefsInstance;
import org.homeunix.drummer.util.Log;
import org.homeunix.drummer.util.LookAndFeelManager;
import org.homeunix.drummer.util.ParseCommands;
import org.homeunix.drummer.util.ParseCommands.ParseException;
import org.homeunix.drummer.view.components.BuddiMenu;

/**
 * @author wyatt
 * @author jdidion
 */
public class Buddi {
	
	private static Boolean isMac;
	private static Boolean isWindows;
	private static final boolean UI_DEBUG = false;
	private static String[] pluginArray = new String[0];
		
	public static boolean isMac(){
		if (isMac == null){
			isMac = !UI_DEBUG && System.getProperty("os.name").startsWith("Mac OS");
		}
		
		return isMac;
	}

	public static Boolean isWindows(){
		if (isWindows == null){
			isWindows = !UI_DEBUG && System.getProperty("os.name").startsWith("Windows");
		}

		return isWindows;
	}
	
	public static String[] getPluginArray(){
		return pluginArray;
	}

	private static void launchGUI(){
		
		// TODO Remove this from stable versions after 1.x.0
		//Temporary notice stating the data format has changed.
	
		if (!PrefsInstance.getInstance().getLastVersionRun().equals(Const.VERSION)){
			if (JOptionPane.showConfirmDialog(null, 
					Translate.getInstance().get(TranslateKeys.UPGRADE_NOTICE),
					Translate.getInstance().get(TranslateKeys.UPGRADE_NOTICE_TITLE),
					JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.WARNING_MESSAGE
			) == JOptionPane.CANCEL_OPTION)
				System.exit(0);
		}
/*
		if (!PrefsInstance.getInstance().getLastVersionRun().equals(Const.VERSION)){
			JOptionPane.showMessageDialog(null, 
					"Warning: This version of Buddi contains code for encrypting and\ndecrypting of data files.  While a few individuals have tested\nas much as possible, it is still likely that there are bugs which\ncould result in loss of data.\n\nMake sure you have backups of any critical files before proceeding!",
					"Warning: Encryption Added",
					JOptionPane.WARNING_MESSAGE
			);
		}
*/
		
		MainBuddiFrame.getInstance().openWindow();
	}
	
	public static void main(String[] args) {
		String prefsLocation = "";
		Integer verbosity = 0;
		String lnf = "";
		String plugins = "";
		
		String help = "USAGE: java -jar Buddi.jar <options>, where options include:\n" 
			+ "-p\tFilename\tPath and name of Preference File\n"
			+ "-v\t0-7\tVerbosity Level (7 = Debug)\n"
			+ "--plugins\tClass1,Class2,Class3,...\n"
			+ "--lnf\tclassName\tJava Look and Feel to use\n";
				
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("-p", prefsLocation);
		map.put("-v", verbosity);
		map.put("--lnf", lnf);
		map.put("--plugins", plugins);
		try{
			map = ParseCommands.parse(args, map, help);
		}
		catch (ParseException pe){
			Log.critical(pe);
			System.exit(1);
		}
		prefsLocation = (String) map.get("-p");
		verbosity = (Integer) map.get("-v");
		lnf = (String) map.get("--lnf");
		plugins = (String) map.get("--plugins");
				
		if (prefsLocation != null){
			PrefsInstance.setLocation(prefsLocation);
		}
		
		if (verbosity != null){
			Log.setLogLevel(verbosity);
		}
		
		if (plugins != null){
			Buddi.pluginArray = plugins.split(",");
		}
		
		LookAndFeelManager.getInstance().setLookAndFeel(lnf);
				
		Translate.getInstance().loadLanguage(
				PrefsInstance.getInstance().getPrefs().getLanguage());
		
		MRJAdapter.setFramelessJMenuBar(new BuddiMenu(null));
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				launchGUI();
			}
		});
	}
}
