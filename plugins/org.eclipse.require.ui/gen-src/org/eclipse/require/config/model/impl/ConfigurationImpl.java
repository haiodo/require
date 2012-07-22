/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.require.config.model.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.require.config.model.Configuration;
import org.eclipse.require.config.model.ModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.require.config.model.impl.ConfigurationImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.require.config.model.impl.ConfigurationImpl#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.eclipse.require.config.model.impl.ConfigurationImpl#getProjects <em>Projects</em>}</li>
 *   <li>{@link org.eclipse.require.config.model.impl.ConfigurationImpl#getFilePath <em>File Path</em>}</li>
 *   <li>{@link org.eclipse.require.config.model.impl.ConfigurationImpl#getRootFolder <em>Root Folder</em>}</li>
 *   <li>{@link org.eclipse.require.config.model.impl.ConfigurationImpl#getStoredFileID <em>Stored File ID</em>}</li>
 *   <li>{@link org.eclipse.require.config.model.impl.ConfigurationImpl#getLastSynchronization <em>Last Synchronization</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConfigurationImpl extends EObjectImpl implements Configuration {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;
	/**
	 * The default value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean enabled = ENABLED_EDEFAULT;
	/**
	 * The default value of the '{@link #getProjects() <em>Projects</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProjects()
	 * @generated
	 * @ordered
	 */
	protected static final int PROJECTS_EDEFAULT = 0;
	/**
	 * The cached value of the '{@link #getProjects() <em>Projects</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProjects()
	 * @generated
	 * @ordered
	 */
	protected int projects = PROJECTS_EDEFAULT;
	/**
	 * The default value of the '{@link #getFilePath() <em>File Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFilePath()
	 * @generated
	 * @ordered
	 */
	protected static final String FILE_PATH_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getFilePath() <em>File Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFilePath()
	 * @generated
	 * @ordered
	 */
	protected String filePath = FILE_PATH_EDEFAULT;
	/**
	 * The default value of the '{@link #getRootFolder() <em>Root Folder</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRootFolder()
	 * @generated
	 * @ordered
	 */
	protected static final String ROOT_FOLDER_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getRootFolder() <em>Root Folder</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRootFolder()
	 * @generated
	 * @ordered
	 */
	protected String rootFolder = ROOT_FOLDER_EDEFAULT;
	/**
	 * The default value of the '{@link #getStoredFileID() <em>Stored File ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStoredFileID()
	 * @generated
	 * @ordered
	 */
	protected static final String STORED_FILE_ID_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getStoredFileID() <em>Stored File ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStoredFileID()
	 * @generated
	 * @ordered
	 */
	protected String storedFileID = STORED_FILE_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getLastSynchronization() <em>Last Synchronization</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastSynchronization()
	 * @generated
	 * @ordered
	 */
	protected static final long LAST_SYNCHRONIZATION_EDEFAULT = 0L;
	/**
	 * The cached value of the '{@link #getLastSynchronization() <em>Last Synchronization</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastSynchronization()
	 * @generated
	 * @ordered
	 */
	protected long lastSynchronization = LAST_SYNCHRONIZATION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.CONFIGURATION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnabled(boolean newEnabled) {
		boolean oldEnabled = enabled;
		enabled = newEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.CONFIGURATION__ENABLED, oldEnabled, enabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getProjects() {
		return projects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProjects(int newProjects) {
		int oldProjects = projects;
		projects = newProjects;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.CONFIGURATION__PROJECTS, oldProjects, projects));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFilePath() {
		return filePath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFilePath(String newFilePath) {
		String oldFilePath = filePath;
		filePath = newFilePath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.CONFIGURATION__FILE_PATH, oldFilePath, filePath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRootFolder() {
		return rootFolder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRootFolder(String newRootFolder) {
		String oldRootFolder = rootFolder;
		rootFolder = newRootFolder;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.CONFIGURATION__ROOT_FOLDER, oldRootFolder, rootFolder));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStoredFileID() {
		return storedFileID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStoredFileID(String newStoredFileID) {
		String oldStoredFileID = storedFileID;
		storedFileID = newStoredFileID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.CONFIGURATION__STORED_FILE_ID, oldStoredFileID, storedFileID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getLastSynchronization() {
		return lastSynchronization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastSynchronization(long newLastSynchronization) {
		long oldLastSynchronization = lastSynchronization;
		lastSynchronization = newLastSynchronization;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.CONFIGURATION__LAST_SYNCHRONIZATION, oldLastSynchronization, lastSynchronization));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.CONFIGURATION__NAME:
				return getName();
			case ModelPackage.CONFIGURATION__ENABLED:
				return isEnabled();
			case ModelPackage.CONFIGURATION__PROJECTS:
				return getProjects();
			case ModelPackage.CONFIGURATION__FILE_PATH:
				return getFilePath();
			case ModelPackage.CONFIGURATION__ROOT_FOLDER:
				return getRootFolder();
			case ModelPackage.CONFIGURATION__STORED_FILE_ID:
				return getStoredFileID();
			case ModelPackage.CONFIGURATION__LAST_SYNCHRONIZATION:
				return getLastSynchronization();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ModelPackage.CONFIGURATION__NAME:
				setName((String)newValue);
				return;
			case ModelPackage.CONFIGURATION__ENABLED:
				setEnabled((Boolean)newValue);
				return;
			case ModelPackage.CONFIGURATION__PROJECTS:
				setProjects((Integer)newValue);
				return;
			case ModelPackage.CONFIGURATION__FILE_PATH:
				setFilePath((String)newValue);
				return;
			case ModelPackage.CONFIGURATION__ROOT_FOLDER:
				setRootFolder((String)newValue);
				return;
			case ModelPackage.CONFIGURATION__STORED_FILE_ID:
				setStoredFileID((String)newValue);
				return;
			case ModelPackage.CONFIGURATION__LAST_SYNCHRONIZATION:
				setLastSynchronization((Long)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ModelPackage.CONFIGURATION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ModelPackage.CONFIGURATION__ENABLED:
				setEnabled(ENABLED_EDEFAULT);
				return;
			case ModelPackage.CONFIGURATION__PROJECTS:
				setProjects(PROJECTS_EDEFAULT);
				return;
			case ModelPackage.CONFIGURATION__FILE_PATH:
				setFilePath(FILE_PATH_EDEFAULT);
				return;
			case ModelPackage.CONFIGURATION__ROOT_FOLDER:
				setRootFolder(ROOT_FOLDER_EDEFAULT);
				return;
			case ModelPackage.CONFIGURATION__STORED_FILE_ID:
				setStoredFileID(STORED_FILE_ID_EDEFAULT);
				return;
			case ModelPackage.CONFIGURATION__LAST_SYNCHRONIZATION:
				setLastSynchronization(LAST_SYNCHRONIZATION_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ModelPackage.CONFIGURATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ModelPackage.CONFIGURATION__ENABLED:
				return enabled != ENABLED_EDEFAULT;
			case ModelPackage.CONFIGURATION__PROJECTS:
				return projects != PROJECTS_EDEFAULT;
			case ModelPackage.CONFIGURATION__FILE_PATH:
				return FILE_PATH_EDEFAULT == null ? filePath != null : !FILE_PATH_EDEFAULT.equals(filePath);
			case ModelPackage.CONFIGURATION__ROOT_FOLDER:
				return ROOT_FOLDER_EDEFAULT == null ? rootFolder != null : !ROOT_FOLDER_EDEFAULT.equals(rootFolder);
			case ModelPackage.CONFIGURATION__STORED_FILE_ID:
				return STORED_FILE_ID_EDEFAULT == null ? storedFileID != null : !STORED_FILE_ID_EDEFAULT.equals(storedFileID);
			case ModelPackage.CONFIGURATION__LAST_SYNCHRONIZATION:
				return lastSynchronization != LAST_SYNCHRONIZATION_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", enabled: ");
		result.append(enabled);
		result.append(", projects: ");
		result.append(projects);
		result.append(", filePath: ");
		result.append(filePath);
		result.append(", rootFolder: ");
		result.append(rootFolder);
		result.append(", storedFileID: ");
		result.append(storedFileID);
		result.append(", lastSynchronization: ");
		result.append(lastSynchronization);
		result.append(')');
		return result.toString();
	}

} //ConfigurationImpl
