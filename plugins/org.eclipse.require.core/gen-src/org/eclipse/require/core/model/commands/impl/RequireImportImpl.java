/**
 */
package org.eclipse.require.core.model.commands.impl;

import java.util.Collection;

import org.eclipse.ecl.core.impl.CommandImpl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.require.core.model.RequireProject;
import org.eclipse.require.core.model.commands.CommandsPackage;
import org.eclipse.require.core.model.commands.RequireImport;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Require Import</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.require.core.model.commands.impl.RequireImportImpl#getProjects <em>Projects</em>}</li>
 *   <li>{@link org.eclipse.require.core.model.commands.impl.RequireImportImpl#getPattern <em>Pattern</em>}</li>
 *   <li>{@link org.eclipse.require.core.model.commands.impl.RequireImportImpl#isOverwrite <em>Overwrite</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RequireImportImpl extends CommandImpl implements RequireImport {
	/**
	 * The cached value of the '{@link #getProjects() <em>Projects</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProjects()
	 * @generated
	 * @ordered
	 */
	protected EList<RequireProject> projects;

	/**
	 * The cached value of the '{@link #getPattern() <em>Pattern</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPattern()
	 * @generated
	 * @ordered
	 */
	protected EList<String> pattern;

	/**
	 * The default value of the '{@link #isOverwrite() <em>Overwrite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOverwrite()
	 * @generated
	 * @ordered
	 */
	protected static final boolean OVERWRITE_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isOverwrite() <em>Overwrite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOverwrite()
	 * @generated
	 * @ordered
	 */
	protected boolean overwrite = OVERWRITE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RequireImportImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CommandsPackage.Literals.REQUIRE_IMPORT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RequireProject> getProjects() {
		if (projects == null) {
			projects = new EObjectResolvingEList<RequireProject>(RequireProject.class, this, CommandsPackage.REQUIRE_IMPORT__PROJECTS);
		}
		return projects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isOverwrite() {
		return overwrite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOverwrite(boolean newOverwrite) {
		boolean oldOverwrite = overwrite;
		overwrite = newOverwrite;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommandsPackage.REQUIRE_IMPORT__OVERWRITE, oldOverwrite, overwrite));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getPattern() {
		if (pattern == null) {
			pattern = new EDataTypeUniqueEList<String>(String.class, this, CommandsPackage.REQUIRE_IMPORT__PATTERN);
		}
		return pattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CommandsPackage.REQUIRE_IMPORT__PROJECTS:
				return getProjects();
			case CommandsPackage.REQUIRE_IMPORT__PATTERN:
				return getPattern();
			case CommandsPackage.REQUIRE_IMPORT__OVERWRITE:
				return isOverwrite();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CommandsPackage.REQUIRE_IMPORT__PROJECTS:
				getProjects().clear();
				getProjects().addAll((Collection<? extends RequireProject>)newValue);
				return;
			case CommandsPackage.REQUIRE_IMPORT__PATTERN:
				getPattern().clear();
				getPattern().addAll((Collection<? extends String>)newValue);
				return;
			case CommandsPackage.REQUIRE_IMPORT__OVERWRITE:
				setOverwrite((Boolean)newValue);
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
			case CommandsPackage.REQUIRE_IMPORT__PROJECTS:
				getProjects().clear();
				return;
			case CommandsPackage.REQUIRE_IMPORT__PATTERN:
				getPattern().clear();
				return;
			case CommandsPackage.REQUIRE_IMPORT__OVERWRITE:
				setOverwrite(OVERWRITE_EDEFAULT);
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
			case CommandsPackage.REQUIRE_IMPORT__PROJECTS:
				return projects != null && !projects.isEmpty();
			case CommandsPackage.REQUIRE_IMPORT__PATTERN:
				return pattern != null && !pattern.isEmpty();
			case CommandsPackage.REQUIRE_IMPORT__OVERWRITE:
				return overwrite != OVERWRITE_EDEFAULT;
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
		result.append(" (pattern: ");
		result.append(pattern);
		result.append(", overwrite: ");
		result.append(overwrite);
		result.append(')');
		return result.toString();
	}

} //RequireImportImpl
