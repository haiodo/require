/**
 */
package org.eclipse.require.core.model.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.require.core.model.ConfigurationPackage;
import org.eclipse.require.core.model.RequireProject;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Require Project</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.require.core.model.impl.RequireProjectImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.require.core.model.impl.RequireProjectImpl#getPath <em>Path</em>}</li>
 *   <li>{@link org.eclipse.require.core.model.impl.RequireProjectImpl#getExistingProjectFullPath <em>Existing Project Full Path</em>}</li>
 *   <li>{@link org.eclipse.require.core.model.impl.RequireProjectImpl#getFullPath <em>Full Path</em>}</li>
 *   <li>{@link org.eclipse.require.core.model.impl.RequireProjectImpl#isProjectExists <em>Project Exists</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RequireProjectImpl extends EObjectImpl implements RequireProject {
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
	 * The default value of the '{@link #getPath() <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPath()
	 * @generated
	 * @ordered
	 */
	protected static final String PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPath() <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPath()
	 * @generated
	 * @ordered
	 */
	protected String path = PATH_EDEFAULT;

	/**
	 * The default value of the '{@link #getExistingProjectFullPath() <em>Existing Project Full Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExistingProjectFullPath()
	 * @generated
	 * @ordered
	 */
	protected static final String EXISTING_PROJECT_FULL_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExistingProjectFullPath() <em>Existing Project Full Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExistingProjectFullPath()
	 * @generated
	 * @ordered
	 */
	protected String existingProjectFullPath = EXISTING_PROJECT_FULL_PATH_EDEFAULT;

	/**
	 * The default value of the '{@link #getFullPath() <em>Full Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFullPath()
	 * @generated
	 * @ordered
	 */
	protected static final String FULL_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFullPath() <em>Full Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFullPath()
	 * @generated
	 * @ordered
	 */
	protected String fullPath = FULL_PATH_EDEFAULT;

	/**
	 * The default value of the '{@link #isProjectExists() <em>Project Exists</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isProjectExists()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PROJECT_EXISTS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isProjectExists() <em>Project Exists</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isProjectExists()
	 * @generated
	 * @ordered
	 */
	protected boolean projectExists = PROJECT_EXISTS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RequireProjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfigurationPackage.Literals.REQUIRE_PROJECT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.REQUIRE_PROJECT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPath() {
		return path;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPath(String newPath) {
		String oldPath = path;
		path = newPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.REQUIRE_PROJECT__PATH, oldPath, path));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExistingProjectFullPath() {
		return existingProjectFullPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExistingProjectFullPath(String newExistingProjectFullPath) {
		String oldExistingProjectFullPath = existingProjectFullPath;
		existingProjectFullPath = newExistingProjectFullPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.REQUIRE_PROJECT__EXISTING_PROJECT_FULL_PATH, oldExistingProjectFullPath, existingProjectFullPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFullPath() {
		return fullPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFullPath(String newFullPath) {
		String oldFullPath = fullPath;
		fullPath = newFullPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.REQUIRE_PROJECT__FULL_PATH, oldFullPath, fullPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isProjectExists() {
		return projectExists;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProjectExists(boolean newProjectExists) {
		boolean oldProjectExists = projectExists;
		projectExists = newProjectExists;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.REQUIRE_PROJECT__PROJECT_EXISTS, oldProjectExists, projectExists));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConfigurationPackage.REQUIRE_PROJECT__NAME:
				return getName();
			case ConfigurationPackage.REQUIRE_PROJECT__PATH:
				return getPath();
			case ConfigurationPackage.REQUIRE_PROJECT__EXISTING_PROJECT_FULL_PATH:
				return getExistingProjectFullPath();
			case ConfigurationPackage.REQUIRE_PROJECT__FULL_PATH:
				return getFullPath();
			case ConfigurationPackage.REQUIRE_PROJECT__PROJECT_EXISTS:
				return isProjectExists();
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
			case ConfigurationPackage.REQUIRE_PROJECT__NAME:
				setName((String)newValue);
				return;
			case ConfigurationPackage.REQUIRE_PROJECT__PATH:
				setPath((String)newValue);
				return;
			case ConfigurationPackage.REQUIRE_PROJECT__EXISTING_PROJECT_FULL_PATH:
				setExistingProjectFullPath((String)newValue);
				return;
			case ConfigurationPackage.REQUIRE_PROJECT__FULL_PATH:
				setFullPath((String)newValue);
				return;
			case ConfigurationPackage.REQUIRE_PROJECT__PROJECT_EXISTS:
				setProjectExists((Boolean)newValue);
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
			case ConfigurationPackage.REQUIRE_PROJECT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ConfigurationPackage.REQUIRE_PROJECT__PATH:
				setPath(PATH_EDEFAULT);
				return;
			case ConfigurationPackage.REQUIRE_PROJECT__EXISTING_PROJECT_FULL_PATH:
				setExistingProjectFullPath(EXISTING_PROJECT_FULL_PATH_EDEFAULT);
				return;
			case ConfigurationPackage.REQUIRE_PROJECT__FULL_PATH:
				setFullPath(FULL_PATH_EDEFAULT);
				return;
			case ConfigurationPackage.REQUIRE_PROJECT__PROJECT_EXISTS:
				setProjectExists(PROJECT_EXISTS_EDEFAULT);
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
			case ConfigurationPackage.REQUIRE_PROJECT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ConfigurationPackage.REQUIRE_PROJECT__PATH:
				return PATH_EDEFAULT == null ? path != null : !PATH_EDEFAULT.equals(path);
			case ConfigurationPackage.REQUIRE_PROJECT__EXISTING_PROJECT_FULL_PATH:
				return EXISTING_PROJECT_FULL_PATH_EDEFAULT == null ? existingProjectFullPath != null : !EXISTING_PROJECT_FULL_PATH_EDEFAULT.equals(existingProjectFullPath);
			case ConfigurationPackage.REQUIRE_PROJECT__FULL_PATH:
				return FULL_PATH_EDEFAULT == null ? fullPath != null : !FULL_PATH_EDEFAULT.equals(fullPath);
			case ConfigurationPackage.REQUIRE_PROJECT__PROJECT_EXISTS:
				return projectExists != PROJECT_EXISTS_EDEFAULT;
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
		result.append(", path: ");
		result.append(path);
		result.append(", existingProjectFullPath: ");
		result.append(existingProjectFullPath);
		result.append(", fullPath: ");
		result.append(fullPath);
		result.append(", projectExists: ");
		result.append(projectExists);
		result.append(')');
		return result.toString();
	}

} //RequireProjectImpl
