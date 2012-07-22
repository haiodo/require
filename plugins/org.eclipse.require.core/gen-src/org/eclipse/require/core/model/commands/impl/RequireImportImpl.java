/**
 */
package org.eclipse.require.core.model.commands.impl;

import java.util.Collection;

import org.eclipse.ecl.core.impl.CommandImpl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import org.eclipse.require.core.model.commands.CommandsPackage;
import org.eclipse.require.core.model.commands.RequireImport;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Require Import</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.require.core.model.commands.impl.RequireImportImpl#getPath <em>Path</em>}</li>
 *   <li>{@link org.eclipse.require.core.model.commands.impl.RequireImportImpl#getMatches <em>Matches</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RequireImportImpl extends CommandImpl implements RequireImport {
	/**
	 * The cached value of the '{@link #getPath() <em>Path</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPath()
	 * @generated
	 * @ordered
	 */
	protected EList<String> path;

	/**
	 * The cached value of the '{@link #getMatches() <em>Matches</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMatches()
	 * @generated
	 * @ordered
	 */
	protected EList<String> matches;

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
	public EList<String> getPath() {
		if (path == null) {
			path = new EDataTypeUniqueEList<String>(String.class, this, CommandsPackage.REQUIRE_IMPORT__PATH);
		}
		return path;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getMatches() {
		if (matches == null) {
			matches = new EDataTypeUniqueEList<String>(String.class, this, CommandsPackage.REQUIRE_IMPORT__MATCHES);
		}
		return matches;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CommandsPackage.REQUIRE_IMPORT__PATH:
				return getPath();
			case CommandsPackage.REQUIRE_IMPORT__MATCHES:
				return getMatches();
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
			case CommandsPackage.REQUIRE_IMPORT__PATH:
				getPath().clear();
				getPath().addAll((Collection<? extends String>)newValue);
				return;
			case CommandsPackage.REQUIRE_IMPORT__MATCHES:
				getMatches().clear();
				getMatches().addAll((Collection<? extends String>)newValue);
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
			case CommandsPackage.REQUIRE_IMPORT__PATH:
				getPath().clear();
				return;
			case CommandsPackage.REQUIRE_IMPORT__MATCHES:
				getMatches().clear();
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
			case CommandsPackage.REQUIRE_IMPORT__PATH:
				return path != null && !path.isEmpty();
			case CommandsPackage.REQUIRE_IMPORT__MATCHES:
				return matches != null && !matches.isEmpty();
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
		result.append(" (path: ");
		result.append(path);
		result.append(", matches: ");
		result.append(matches);
		result.append(')');
		return result.toString();
	}

} //RequireImportImpl
