/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.require.core.configuration.runtime;

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
 * @see org.eclipse.require.core.configuration.runtime.RuntimeFactory
 * @model kind="package"
 * @generated
 */
public interface RuntimePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "runtime";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://org.eclipse.require.runtime/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.require.core.configuration.runtime";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RuntimePackage eINSTANCE = org.eclipse.require.core.configuration.runtime.impl.RuntimePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.require.core.configuration.runtime.impl.RuntimeConfigurationImpl <em>Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.require.core.configuration.runtime.impl.RuntimeConfigurationImpl
	 * @see org.eclipse.require.core.configuration.runtime.impl.RuntimePackageImpl#getRuntimeConfiguration()
	 * @generated
	 */
	int RUNTIME_CONFIGURATION = 0;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNTIME_CONFIGURATION__PATH = 0;

	/**
	 * The feature id for the '<em><b>Components</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNTIME_CONFIGURATION__COMPONENTS = 1;

	/**
	 * The number of structural features of the '<em>Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNTIME_CONFIGURATION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.require.core.configuration.runtime.impl.RuntimeComponentImpl <em>Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.require.core.configuration.runtime.impl.RuntimeComponentImpl
	 * @see org.eclipse.require.core.configuration.runtime.impl.RuntimePackageImpl#getRuntimeComponent()
	 * @generated
	 */
	int RUNTIME_COMPONENT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNTIME_COMPONENT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Plugins</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNTIME_COMPONENT__PLUGINS = 1;

	/**
	 * The number of structural features of the '<em>Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNTIME_COMPONENT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.require.core.configuration.runtime.impl.RuntimePluginImpl <em>Plugin</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.require.core.configuration.runtime.impl.RuntimePluginImpl
	 * @see org.eclipse.require.core.configuration.runtime.impl.RuntimePackageImpl#getRuntimePlugin()
	 * @generated
	 */
	int RUNTIME_PLUGIN = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNTIME_PLUGIN__NAME = 0;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNTIME_PLUGIN__PATH = 1;

	/**
	 * The number of structural features of the '<em>Plugin</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNTIME_PLUGIN_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link org.eclipse.require.core.configuration.runtime.RuntimeConfiguration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configuration</em>'.
	 * @see org.eclipse.require.core.configuration.runtime.RuntimeConfiguration
	 * @generated
	 */
	EClass getRuntimeConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.require.core.configuration.runtime.RuntimeConfiguration#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see org.eclipse.require.core.configuration.runtime.RuntimeConfiguration#getPath()
	 * @see #getRuntimeConfiguration()
	 * @generated
	 */
	EAttribute getRuntimeConfiguration_Path();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.require.core.configuration.runtime.RuntimeConfiguration#getComponents <em>Components</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Components</em>'.
	 * @see org.eclipse.require.core.configuration.runtime.RuntimeConfiguration#getComponents()
	 * @see #getRuntimeConfiguration()
	 * @generated
	 */
	EReference getRuntimeConfiguration_Components();

	/**
	 * Returns the meta object for class '{@link org.eclipse.require.core.configuration.runtime.RuntimeComponent <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component</em>'.
	 * @see org.eclipse.require.core.configuration.runtime.RuntimeComponent
	 * @generated
	 */
	EClass getRuntimeComponent();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.require.core.configuration.runtime.RuntimeComponent#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.require.core.configuration.runtime.RuntimeComponent#getName()
	 * @see #getRuntimeComponent()
	 * @generated
	 */
	EAttribute getRuntimeComponent_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.require.core.configuration.runtime.RuntimeComponent#getPlugins <em>Plugins</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Plugins</em>'.
	 * @see org.eclipse.require.core.configuration.runtime.RuntimeComponent#getPlugins()
	 * @see #getRuntimeComponent()
	 * @generated
	 */
	EReference getRuntimeComponent_Plugins();

	/**
	 * Returns the meta object for class '{@link org.eclipse.require.core.configuration.runtime.RuntimePlugin <em>Plugin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Plugin</em>'.
	 * @see org.eclipse.require.core.configuration.runtime.RuntimePlugin
	 * @generated
	 */
	EClass getRuntimePlugin();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.require.core.configuration.runtime.RuntimePlugin#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.require.core.configuration.runtime.RuntimePlugin#getName()
	 * @see #getRuntimePlugin()
	 * @generated
	 */
	EAttribute getRuntimePlugin_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.require.core.configuration.runtime.RuntimePlugin#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see org.eclipse.require.core.configuration.runtime.RuntimePlugin#getPath()
	 * @see #getRuntimePlugin()
	 * @generated
	 */
	EAttribute getRuntimePlugin_Path();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	RuntimeFactory getRuntimeFactory();

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
		 * The meta object literal for the '{@link org.eclipse.require.core.configuration.runtime.impl.RuntimeConfigurationImpl <em>Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.require.core.configuration.runtime.impl.RuntimeConfigurationImpl
		 * @see org.eclipse.require.core.configuration.runtime.impl.RuntimePackageImpl#getRuntimeConfiguration()
		 * @generated
		 */
		EClass RUNTIME_CONFIGURATION = eINSTANCE.getRuntimeConfiguration();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RUNTIME_CONFIGURATION__PATH = eINSTANCE.getRuntimeConfiguration_Path();

		/**
		 * The meta object literal for the '<em><b>Components</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RUNTIME_CONFIGURATION__COMPONENTS = eINSTANCE.getRuntimeConfiguration_Components();

		/**
		 * The meta object literal for the '{@link org.eclipse.require.core.configuration.runtime.impl.RuntimeComponentImpl <em>Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.require.core.configuration.runtime.impl.RuntimeComponentImpl
		 * @see org.eclipse.require.core.configuration.runtime.impl.RuntimePackageImpl#getRuntimeComponent()
		 * @generated
		 */
		EClass RUNTIME_COMPONENT = eINSTANCE.getRuntimeComponent();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RUNTIME_COMPONENT__NAME = eINSTANCE.getRuntimeComponent_Name();

		/**
		 * The meta object literal for the '<em><b>Plugins</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RUNTIME_COMPONENT__PLUGINS = eINSTANCE.getRuntimeComponent_Plugins();

		/**
		 * The meta object literal for the '{@link org.eclipse.require.core.configuration.runtime.impl.RuntimePluginImpl <em>Plugin</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.require.core.configuration.runtime.impl.RuntimePluginImpl
		 * @see org.eclipse.require.core.configuration.runtime.impl.RuntimePackageImpl#getRuntimePlugin()
		 * @generated
		 */
		EClass RUNTIME_PLUGIN = eINSTANCE.getRuntimePlugin();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RUNTIME_PLUGIN__NAME = eINSTANCE.getRuntimePlugin_Name();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RUNTIME_PLUGIN__PATH = eINSTANCE.getRuntimePlugin_Path();

	}

} //RuntimePackage
