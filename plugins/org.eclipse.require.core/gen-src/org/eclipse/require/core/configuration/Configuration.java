package org.eclipse.require.core.configuration;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * 
 * @model
 * @author haiodo@gmail.com
 *
 */
public interface Configuration extends EObject {

	/**
	 * Returns the value of the '<em><b>Components</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.require.core.configuration.Component}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Components</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Components</em>' containment reference list.
	 * @see org.eclipse.require.core.configuration.ConfigurationPackage#getConfiguration_Components()
	 * @model containment="true"
	 * @generated
	 */
	EList<Component> getComponents();

}
