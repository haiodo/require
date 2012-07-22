/**
 */
package org.eclipse.require.core.model.commands;

import org.eclipse.ecl.core.CorePackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.require.core.model.commands.CommandsFactory
 * @model kind="package"
 * @generated
 */
public interface CommandsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "commands";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://org.eclipse.require.commands/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.reqiure.core.commands";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CommandsPackage eINSTANCE = org.eclipse.require.core.model.commands.impl.CommandsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.require.core.model.commands.impl.RequireFindProjectsImpl <em>Require Find Projects</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.require.core.model.commands.impl.RequireFindProjectsImpl
	 * @see org.eclipse.require.core.model.commands.impl.CommandsPackageImpl#getRequireFindProjects()
	 * @generated
	 */
	int REQUIRE_FIND_PROJECTS = 0;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRE_FIND_PROJECTS__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRE_FIND_PROJECTS__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Roots</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRE_FIND_PROJECTS__ROOTS = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Require Find Projects</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRE_FIND_PROJECTS_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.require.core.model.commands.impl.RequireImportImpl <em>Require Import</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.require.core.model.commands.impl.RequireImportImpl
	 * @see org.eclipse.require.core.model.commands.impl.CommandsPackageImpl#getRequireImport()
	 * @generated
	 */
	int REQUIRE_IMPORT = 1;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRE_IMPORT__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRE_IMPORT__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRE_IMPORT__PATH = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Matches</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRE_IMPORT__MATCHES = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Require Import</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRE_IMPORT_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 2;


	/**
	 * Returns the meta object for class '{@link org.eclipse.require.core.model.commands.RequireFindProjects <em>Require Find Projects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Require Find Projects</em>'.
	 * @see org.eclipse.require.core.model.commands.RequireFindProjects
	 * @generated
	 */
	EClass getRequireFindProjects();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.require.core.model.commands.RequireFindProjects#getRoots <em>Roots</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Roots</em>'.
	 * @see org.eclipse.require.core.model.commands.RequireFindProjects#getRoots()
	 * @see #getRequireFindProjects()
	 * @generated
	 */
	EReference getRequireFindProjects_Roots();

	/**
	 * Returns the meta object for class '{@link org.eclipse.require.core.model.commands.RequireImport <em>Require Import</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Require Import</em>'.
	 * @see org.eclipse.require.core.model.commands.RequireImport
	 * @generated
	 */
	EClass getRequireImport();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.require.core.model.commands.RequireImport#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Path</em>'.
	 * @see org.eclipse.require.core.model.commands.RequireImport#getPath()
	 * @see #getRequireImport()
	 * @generated
	 */
	EAttribute getRequireImport_Path();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.require.core.model.commands.RequireImport#getMatches <em>Matches</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Matches</em>'.
	 * @see org.eclipse.require.core.model.commands.RequireImport#getMatches()
	 * @see #getRequireImport()
	 * @generated
	 */
	EAttribute getRequireImport_Matches();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CommandsFactory getCommandsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.require.core.model.commands.impl.RequireFindProjectsImpl <em>Require Find Projects</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.require.core.model.commands.impl.RequireFindProjectsImpl
		 * @see org.eclipse.require.core.model.commands.impl.CommandsPackageImpl#getRequireFindProjects()
		 * @generated
		 */
		EClass REQUIRE_FIND_PROJECTS = eINSTANCE.getRequireFindProjects();

		/**
		 * The meta object literal for the '<em><b>Roots</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUIRE_FIND_PROJECTS__ROOTS = eINSTANCE.getRequireFindProjects_Roots();

		/**
		 * The meta object literal for the '{@link org.eclipse.require.core.model.commands.impl.RequireImportImpl <em>Require Import</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.require.core.model.commands.impl.RequireImportImpl
		 * @see org.eclipse.require.core.model.commands.impl.CommandsPackageImpl#getRequireImport()
		 * @generated
		 */
		EClass REQUIRE_IMPORT = eINSTANCE.getRequireImport();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUIRE_IMPORT__PATH = eINSTANCE.getRequireImport_Path();

		/**
		 * The meta object literal for the '<em><b>Matches</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUIRE_IMPORT__MATCHES = eINSTANCE.getRequireImport_Matches();

	}

} //CommandsPackage
