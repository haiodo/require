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
 * A representation of the model object '<em><b>Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.require.core.configuration.runtime.RuntimeComponent#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.require.core.configuration.runtime.RuntimeComponent#getPlugins <em>Plugins</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.require.core.configuration.runtime.RuntimePackage#getRuntimeComponent()
 * @model
 * @generated
 */
public interface RuntimeComponent extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.require.core.configuration.runtime.RuntimePackage#getRuntimeComponent_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.require.core.configuration.runtime.RuntimeComponent#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Plugins</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.require.core.configuration.runtime.RuntimePlugin}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Plugins</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Plugins</em>' containment reference list.
	 * @see org.eclipse.require.core.configuration.runtime.RuntimePackage#getRuntimeComponent_Plugins()
	 * @model containment="true"
	 * @generated
	 */
	EList<RuntimePlugin> getPlugins();

} // RuntimeComponent
