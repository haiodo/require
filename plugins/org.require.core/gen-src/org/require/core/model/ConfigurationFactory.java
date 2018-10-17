/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.require.core.model;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.require.core.model.ConfigurationPackage
 * @generated
 */
public interface ConfigurationFactory extends EFactory {
	/**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	ConfigurationFactory eINSTANCE = org.require.core.model.impl.ConfigurationFactoryImpl.init();

	/**
     * Returns a new object of class '<em>Require Project</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Require Project</em>'.
     * @generated
     */
	RequireProject createRequireProject();

	/**
     * Returns a new object of class '<em>Eclipse Project</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Eclipse Project</em>'.
     * @generated
     */
	EclipseProject createEclipseProject();

	/**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
	ConfigurationPackage getConfigurationPackage();

} //ConfigurationFactory
