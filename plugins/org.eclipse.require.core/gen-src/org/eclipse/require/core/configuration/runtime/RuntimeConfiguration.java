/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.require.core.configuration.runtime;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.require.core.configuration.runtime.RuntimeConfiguration#getPath <em>Path</em>}</li>
 *   <li>{@link org.eclipse.require.core.configuration.runtime.RuntimeConfiguration#getComponents <em>Components</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.require.core.configuration.runtime.RuntimePackage#getRuntimeConfiguration()
 * @model
 * @generated
 */
public interface RuntimeConfiguration extends EObject {
	/**
	 * Returns the value of the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path</em>' attribute.
	 * @see #setPath(String)
	 * @see org.eclipse.require.core.configuration.runtime.RuntimePackage#getRuntimeConfiguration_Path()
	 * @model
	 * @generated
	 */
	String getPath();

	/**
	 * Sets the value of the '{@link org.eclipse.require.core.configuration.runtime.RuntimeConfiguration#getPath <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path</em>' attribute.
	 * @see #getPath()
	 * @generated
	 */
	void setPath(String value);

	/**
	 * Returns the value of the '<em><b>Components</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.require.core.configuration.runtime.RuntimeComponent}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Components</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Components</em>' containment reference list.
	 * @see org.eclipse.require.core.configuration.runtime.RuntimePackage#getRuntimeConfiguration_Components()
	 * @model containment="true"
	 * @generated
	 */
	EList<RuntimeComponent> getComponents();

} // RuntimeConfiguration
