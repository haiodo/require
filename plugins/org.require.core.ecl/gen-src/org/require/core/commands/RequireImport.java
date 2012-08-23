/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.require.core.commands;

import org.eclipse.ecl.core.Command;

import org.eclipse.emf.common.util.EList;

import org.require.core.model.RequireProject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Require Import</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.require.core.commands.RequireImport#getProjects <em>Projects</em>}</li>
 *   <li>{@link org.require.core.commands.RequireImport#getPattern <em>Pattern</em>}</li>
 *   <li>{@link org.require.core.commands.RequireImport#isOverwrite <em>Overwrite</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.require.core.commands.CommandsPackage#getRequireImport()
 * @model
 * @generated
 */
public interface RequireImport extends Command {
	/**
	 * Returns the value of the '<em><b>Projects</b></em>' reference list.
	 * The list contents are of type {@link org.require.core.model.RequireProject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Projects</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Projects</em>' reference list.
	 * @see org.require.core.commands.CommandsPackage#getRequireImport_Projects()
	 * @model
	 * @generated
	 */
	EList<RequireProject> getProjects();

	/**
	 * Returns the value of the '<em><b>Pattern</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pattern</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pattern</em>' attribute list.
	 * @see org.require.core.commands.CommandsPackage#getRequireImport_Pattern()
	 * @model
	 * @generated
	 */
	EList<String> getPattern();

	/**
	 * Returns the value of the '<em><b>Overwrite</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Overwrite</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Overwrite</em>' attribute.
	 * @see #setOverwrite(boolean)
	 * @see org.require.core.commands.CommandsPackage#getRequireImport_Overwrite()
	 * @model default="true"
	 * @generated
	 */
	boolean isOverwrite();

	/**
	 * Sets the value of the '{@link org.require.core.commands.RequireImport#isOverwrite <em>Overwrite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Overwrite</em>' attribute.
	 * @see #isOverwrite()
	 * @generated
	 */
	void setOverwrite(boolean value);

} // RequireImport
