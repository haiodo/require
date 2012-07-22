/**
 */
package org.eclipse.require.core.model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Eclipse Project</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.require.core.model.EclipseProject#getProject <em>Project</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.require.core.model.ConfigurationPackage#getEclipseProject()
 * @model
 * @generated
 */
public interface EclipseProject extends EObject {
	/**
	 * Returns the value of the '<em><b>Project</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project</em>' attribute.
	 * @see #setProject(Object)
	 * @see org.eclipse.require.core.model.ConfigurationPackage#getEclipseProject_Project()
	 * @model
	 * @generated
	 */
	Object getProject();

	/**
	 * Sets the value of the '{@link org.eclipse.require.core.model.EclipseProject#getProject <em>Project</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project</em>' attribute.
	 * @see #getProject()
	 * @generated
	 */
	void setProject(Object value);

} // EclipseProject
