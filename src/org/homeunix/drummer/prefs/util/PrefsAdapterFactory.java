/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.homeunix.drummer.prefs.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.homeunix.drummer.prefs.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.homeunix.drummer.prefs.PrefsPackage
 * @generated
 */
public class PrefsAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static PrefsPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrefsAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = PrefsPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch the delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PrefsSwitch modelSwitch =
		new PrefsSwitch() {
			public Object caseDictData(DictData object) {
				return createDictDataAdapter();
			}
			public Object caseDictEntry(DictEntry object) {
				return createDictEntryAdapter();
			}
			public Object caseInterval(Interval object) {
				return createIntervalAdapter();
			}
			public Object caseIntervals(Intervals object) {
				return createIntervalsAdapter();
			}
			public Object caseListAttributes(ListAttributes object) {
				return createListAttributesAdapter();
			}
			public Object caseListEntry(ListEntry object) {
				return createListEntryAdapter();
			}
			public Object caseLists(Lists object) {
				return createListsAdapter();
			}
			public Object casePrefs(Prefs object) {
				return createPrefsAdapter();
			}
			public Object caseUserPrefs(UserPrefs object) {
				return createUserPrefsAdapter();
			}
			public Object caseVersion(Version object) {
				return createVersionAdapter();
			}
			public Object caseWindowAttributes(WindowAttributes object) {
				return createWindowAttributesAdapter();
			}
			public Object caseWindows(Windows object) {
				return createWindowsAdapter();
			}
			public Object defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	public Adapter createAdapter(Notifier target) {
		return (Adapter)modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.homeunix.drummer.prefs.DictData <em>Dict Data</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.homeunix.drummer.prefs.DictData
	 * @generated
	 */
	public Adapter createDictDataAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.homeunix.drummer.prefs.DictEntry <em>Dict Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.homeunix.drummer.prefs.DictEntry
	 * @generated
	 */
	public Adapter createDictEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.homeunix.drummer.prefs.Interval <em>Interval</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.homeunix.drummer.prefs.Interval
	 * @generated
	 */
	public Adapter createIntervalAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.homeunix.drummer.prefs.Intervals <em>Intervals</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.homeunix.drummer.prefs.Intervals
	 * @generated
	 */
	public Adapter createIntervalsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.homeunix.drummer.prefs.ListAttributes <em>List Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.homeunix.drummer.prefs.ListAttributes
	 * @generated
	 */
	public Adapter createListAttributesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.homeunix.drummer.prefs.ListEntry <em>List Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.homeunix.drummer.prefs.ListEntry
	 * @generated
	 */
	public Adapter createListEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.homeunix.drummer.prefs.Lists <em>Lists</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.homeunix.drummer.prefs.Lists
	 * @generated
	 */
	public Adapter createListsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.homeunix.drummer.prefs.Prefs <em>Prefs</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.homeunix.drummer.prefs.Prefs
	 * @generated
	 */
	public Adapter createPrefsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.homeunix.drummer.prefs.UserPrefs <em>User Prefs</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.homeunix.drummer.prefs.UserPrefs
	 * @generated
	 */
	public Adapter createUserPrefsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.homeunix.drummer.prefs.Version <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.homeunix.drummer.prefs.Version
	 * @generated
	 */
	public Adapter createVersionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.homeunix.drummer.prefs.WindowAttributes <em>Window Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.homeunix.drummer.prefs.WindowAttributes
	 * @generated
	 */
	public Adapter createWindowAttributesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.homeunix.drummer.prefs.Windows <em>Windows</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.homeunix.drummer.prefs.Windows
	 * @generated
	 */
	public Adapter createWindowsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //PrefsAdapterFactory
