/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.require.egit;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.require.egit.EgitPackage
 * @generated
 */
public interface EgitFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EgitFactory eINSTANCE = org.require.egit.impl.EgitFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Require Git Root</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Require Git Root</em>'.
	 * @generated
	 */
	RequireGitRoot createRequireGitRoot();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	EgitPackage getEgitPackage();

} //EgitFactory
