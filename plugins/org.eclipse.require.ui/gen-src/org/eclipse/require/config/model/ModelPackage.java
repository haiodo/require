/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.require.config.model;

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
 * @see org.eclipse.require.config.model.ModelFactory
 * @model kind="package"
 * @generated
 */
public interface ModelPackage extends EPackage {
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
	String eNS_URI = "http:///org/eclipse/require/config/model.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.require.config.model";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelPackage eINSTANCE = org.eclipse.require.config.model.impl.ModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.require.config.model.impl.ConfigurationImpl <em>Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.require.config.model.impl.ConfigurationImpl
	 * @see org.eclipse.require.config.model.impl.ModelPackageImpl#getConfiguration()
	 * @generated
	 */
	int CONFIGURATION = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__NAME = 0;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__ENABLED = 1;

	/**
	 * The feature id for the '<em><b>Projects</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__PROJECTS = 2;

	/**
	 * The feature id for the '<em><b>File Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__FILE_PATH = 3;

	/**
	 * The feature id for the '<em><b>Root Folder</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__ROOT_FOLDER = 4;

	/**
	 * The feature id for the '<em><b>Stored File ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__STORED_FILE_ID = 5;

	/**
	 * The feature id for the '<em><b>Last Synchronization</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__LAST_SYNCHRONIZATION = 6;

	/**
	 * The number of structural features of the '<em>Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_FEATURE_COUNT = 7;


	/**
	 * Returns the meta object for class '{@link org.eclipse.require.config.model.Configuration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configuration</em>'.
	 * @see org.eclipse.require.config.model.Configuration
	 * @generated
	 */
	EClass getConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.require.config.model.Configuration#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.require.config.model.Configuration#getName()
	 * @see #getConfiguration()
	 * @generated
	 */
	EAttribute getConfiguration_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.require.config.model.Configuration#isEnabled <em>Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled</em>'.
	 * @see org.eclipse.require.config.model.Configuration#isEnabled()
	 * @see #getConfiguration()
	 * @generated
	 */
	EAttribute getConfiguration_Enabled();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.require.config.model.Configuration#getProjects <em>Projects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Projects</em>'.
	 * @see org.eclipse.require.config.model.Configuration#getProjects()
	 * @see #getConfiguration()
	 * @generated
	 */
	EAttribute getConfiguration_Projects();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.require.config.model.Configuration#getFilePath <em>File Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>File Path</em>'.
	 * @see org.eclipse.require.config.model.Configuration#getFilePath()
	 * @see #getConfiguration()
	 * @generated
	 */
	EAttribute getConfiguration_FilePath();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.require.config.model.Configuration#getRootFolder <em>Root Folder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Root Folder</em>'.
	 * @see org.eclipse.require.config.model.Configuration#getRootFolder()
	 * @see #getConfiguration()
	 * @generated
	 */
	EAttribute getConfiguration_RootFolder();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.require.config.model.Configuration#getStoredFileID <em>Stored File ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stored File ID</em>'.
	 * @see org.eclipse.require.config.model.Configuration#getStoredFileID()
	 * @see #getConfiguration()
	 * @generated
	 */
	EAttribute getConfiguration_StoredFileID();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.require.config.model.Configuration#getLastSynchronization <em>Last Synchronization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Synchronization</em>'.
	 * @see org.eclipse.require.config.model.Configuration#getLastSynchronization()
	 * @see #getConfiguration()
	 * @generated
	 */
	EAttribute getConfiguration_LastSynchronization();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ModelFactory getModelFactory();

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
		 * The meta object literal for the '{@link org.eclipse.require.config.model.impl.ConfigurationImpl <em>Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.require.config.model.impl.ConfigurationImpl
		 * @see org.eclipse.require.config.model.impl.ModelPackageImpl#getConfiguration()
		 * @generated
		 */
		EClass CONFIGURATION = eINSTANCE.getConfiguration();
		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION__NAME = eINSTANCE.getConfiguration_Name();
		/**
		 * The meta object literal for the '<em><b>Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION__ENABLED = eINSTANCE.getConfiguration_Enabled();
		/**
		 * The meta object literal for the '<em><b>Projects</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION__PROJECTS = eINSTANCE.getConfiguration_Projects();
		/**
		 * The meta object literal for the '<em><b>File Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION__FILE_PATH = eINSTANCE.getConfiguration_FilePath();
		/**
		 * The meta object literal for the '<em><b>Root Folder</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION__ROOT_FOLDER = eINSTANCE.getConfiguration_RootFolder();
		/**
		 * The meta object literal for the '<em><b>Stored File ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION__STORED_FILE_ID = eINSTANCE.getConfiguration_StoredFileID();
		/**
		 * The meta object literal for the '<em><b>Last Synchronization</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION__LAST_SYNCHRONIZATION = eINSTANCE.getConfiguration_LastSynchronization();

	}

} //ModelPackage
