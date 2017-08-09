/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.require.core.model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

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
 * @see org.require.core.model.ConfigurationFactory
 * @model kind="package"
 * @generated
 */
public interface ConfigurationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "model";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://org.require/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.require.core";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ConfigurationPackage eINSTANCE = org.require.core.model.impl.ConfigurationPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.require.core.model.impl.RequireProjectImpl <em>Require Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.require.core.model.impl.RequireProjectImpl
	 * @see org.require.core.model.impl.ConfigurationPackageImpl#getRequireProject()
	 * @generated
	 */
	int REQUIRE_PROJECT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRE_PROJECT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRE_PROJECT__PATH = 1;

	/**
	 * The feature id for the '<em><b>Existing Project Full Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRE_PROJECT__EXISTING_PROJECT_FULL_PATH = 2;

	/**
	 * The feature id for the '<em><b>Full Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRE_PROJECT__FULL_PATH = 3;

	/**
	 * The feature id for the '<em><b>Project Exists</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRE_PROJECT__PROJECT_EXISTS = 4;

	/**
	 * The feature id for the '<em><b>Dependencies</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRE_PROJECT__DEPENDENCIES = 5;

	/**
	 * The feature id for the '<em><b>Parent Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRE_PROJECT__PARENT_PATH = 6;

	/**
	 * The number of structural features of the '<em>Require Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRE_PROJECT_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link org.require.core.model.impl.EclipseProjectImpl <em>Eclipse Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.require.core.model.impl.EclipseProjectImpl
	 * @see org.require.core.model.impl.ConfigurationPackageImpl#getEclipseProject()
	 * @generated
	 */
	int ECLIPSE_PROJECT = 1;

	/**
	 * The feature id for the '<em><b>Project</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLIPSE_PROJECT__PROJECT = 0;

	/**
	 * The number of structural features of the '<em>Eclipse Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLIPSE_PROJECT_FEATURE_COUNT = 1;


	/**
	 * Returns the meta object for class '{@link org.require.core.model.RequireProject <em>Require Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Require Project</em>'.
	 * @see org.require.core.model.RequireProject
	 * @generated
	 */
	EClass getRequireProject();

	/**
	 * Returns the meta object for the attribute '{@link org.require.core.model.RequireProject#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.require.core.model.RequireProject#getName()
	 * @see #getRequireProject()
	 * @generated
	 */
	EAttribute getRequireProject_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.require.core.model.RequireProject#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see org.require.core.model.RequireProject#getPath()
	 * @see #getRequireProject()
	 * @generated
	 */
	EAttribute getRequireProject_Path();

	/**
	 * Returns the meta object for the attribute '{@link org.require.core.model.RequireProject#getExistingProjectFullPath <em>Existing Project Full Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Existing Project Full Path</em>'.
	 * @see org.require.core.model.RequireProject#getExistingProjectFullPath()
	 * @see #getRequireProject()
	 * @generated
	 */
	EAttribute getRequireProject_ExistingProjectFullPath();

	/**
	 * Returns the meta object for the attribute '{@link org.require.core.model.RequireProject#getFullPath <em>Full Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Full Path</em>'.
	 * @see org.require.core.model.RequireProject#getFullPath()
	 * @see #getRequireProject()
	 * @generated
	 */
	EAttribute getRequireProject_FullPath();

	/**
	 * Returns the meta object for the attribute '{@link org.require.core.model.RequireProject#isProjectExists <em>Project Exists</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Project Exists</em>'.
	 * @see org.require.core.model.RequireProject#isProjectExists()
	 * @see #getRequireProject()
	 * @generated
	 */
	EAttribute getRequireProject_ProjectExists();

	/**
	 * Returns the meta object for the attribute list '{@link org.require.core.model.RequireProject#getDependencies <em>Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Dependencies</em>'.
	 * @see org.require.core.model.RequireProject#getDependencies()
	 * @see #getRequireProject()
	 * @generated
	 */
	EAttribute getRequireProject_Dependencies();

	/**
	 * Returns the meta object for the attribute '{@link org.require.core.model.RequireProject#getParentPath <em>Parent Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Parent Path</em>'.
	 * @see org.require.core.model.RequireProject#getParentPath()
	 * @see #getRequireProject()
	 * @generated
	 */
	EAttribute getRequireProject_ParentPath();

	/**
	 * Returns the meta object for class '{@link org.require.core.model.EclipseProject <em>Eclipse Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Eclipse Project</em>'.
	 * @see org.require.core.model.EclipseProject
	 * @generated
	 */
	EClass getEclipseProject();

	/**
	 * Returns the meta object for the attribute '{@link org.require.core.model.EclipseProject#getProject <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Project</em>'.
	 * @see org.require.core.model.EclipseProject#getProject()
	 * @see #getEclipseProject()
	 * @generated
	 */
	EAttribute getEclipseProject_Project();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ConfigurationFactory getConfigurationFactory();

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
		 * The meta object literal for the '{@link org.require.core.model.impl.RequireProjectImpl <em>Require Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.require.core.model.impl.RequireProjectImpl
		 * @see org.require.core.model.impl.ConfigurationPackageImpl#getRequireProject()
		 * @generated
		 */
		EClass REQUIRE_PROJECT = eINSTANCE.getRequireProject();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUIRE_PROJECT__NAME = eINSTANCE.getRequireProject_Name();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUIRE_PROJECT__PATH = eINSTANCE.getRequireProject_Path();

		/**
		 * The meta object literal for the '<em><b>Existing Project Full Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUIRE_PROJECT__EXISTING_PROJECT_FULL_PATH = eINSTANCE.getRequireProject_ExistingProjectFullPath();

		/**
		 * The meta object literal for the '<em><b>Full Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUIRE_PROJECT__FULL_PATH = eINSTANCE.getRequireProject_FullPath();

		/**
		 * The meta object literal for the '<em><b>Project Exists</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUIRE_PROJECT__PROJECT_EXISTS = eINSTANCE.getRequireProject_ProjectExists();

		/**
		 * The meta object literal for the '<em><b>Dependencies</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUIRE_PROJECT__DEPENDENCIES = eINSTANCE.getRequireProject_Dependencies();

		/**
		 * The meta object literal for the '<em><b>Parent Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUIRE_PROJECT__PARENT_PATH = eINSTANCE.getRequireProject_ParentPath();

		/**
		 * The meta object literal for the '{@link org.require.core.model.impl.EclipseProjectImpl <em>Eclipse Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.require.core.model.impl.EclipseProjectImpl
		 * @see org.require.core.model.impl.ConfigurationPackageImpl#getEclipseProject()
		 * @generated
		 */
		EClass ECLIPSE_PROJECT = eINSTANCE.getEclipseProject();

		/**
		 * The meta object literal for the '<em><b>Project</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECLIPSE_PROJECT__PROJECT = eINSTANCE.getEclipseProject_Project();

	}

} //ConfigurationPackage
