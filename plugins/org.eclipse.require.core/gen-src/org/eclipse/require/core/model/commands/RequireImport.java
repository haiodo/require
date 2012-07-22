/**
 */
package org.eclipse.require.core.model.commands;

import org.eclipse.ecl.core.Command;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Require Import</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.require.core.model.commands.RequireImport#getPath <em>Path</em>}</li>
 *   <li>{@link org.eclipse.require.core.model.commands.RequireImport#getMatches <em>Matches</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.require.core.model.commands.CommandsPackage#getRequireImport()
 * @model
 * @generated
 */
public interface RequireImport extends Command {
	/**
	 * Returns the value of the '<em><b>Path</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path</em>' attribute list.
	 * @see org.eclipse.require.core.model.commands.CommandsPackage#getRequireImport_Path()
	 * @model
	 * @generated
	 */
	EList<String> getPath();

	/**
	 * Returns the value of the '<em><b>Matches</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Matches</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Matches</em>' attribute list.
	 * @see org.eclipse.require.core.model.commands.CommandsPackage#getRequireImport_Matches()
	 * @model
	 * @generated
	 */
	EList<String> getMatches();

} // RequireImport
