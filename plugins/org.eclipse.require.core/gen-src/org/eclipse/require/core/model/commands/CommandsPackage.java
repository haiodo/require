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
	 * The feature id for the '<em><b>Projects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRE_IMPORT__PROJECTS = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Pattern</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRE_IMPORT__PATTERN = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Overwrite</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRE_IMPORT__OVERWRITE = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Require Import</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRE_IMPORT_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 3;


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
	 * Returns the meta object for the reference list '{@link org.eclipse.require.core.model.commands.RequireImport#getProjects <em>Projects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Projects</em>'.
	 * @see org.eclipse.require.core.model.commands.RequireImport#getProjects()
	 * @see #getRequireImport()
	 * @generated
	 */
	EReference getRequireImport_Projects();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.require.core.model.commands.RequireImport#isOverwrite <em>Overwrite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Overwrite</em>'.
	 * @see org.eclipse.require.core.model.commands.RequireImport#isOverwrite()
	 * @see #getRequireImport()
	 * @generated
	 */
	EAttribute getRequireImport_Overwrite();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.require.core.model.commands.RequireImport#getPattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Pattern</em>'.
	 * @see org.eclipse.require.core.model.commands.RequireImport#getPattern()
	 * @see #getRequireImport()
	 * @generated
	 */
	EAttribute getRequireImport_Pattern();

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
		 * The meta object literal for the '<em><b>Projects</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUIRE_IMPORT__PROJECTS = eINSTANCE.getRequireImport_Projects();

		/**
		 * The meta object literal for the '<em><b>Overwrite</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUIRE_IMPORT__OVERWRITE = eINSTANCE.getRequireImport_Overwrite();

		/**
		 * The meta object literal for the '<em><b>Pattern</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUIRE_IMPORT__PATTERN = eINSTANCE.getRequireImport_Pattern();

	}

} //CommandsPackage
