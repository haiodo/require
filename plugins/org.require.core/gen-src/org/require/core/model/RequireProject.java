/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.require.core.model;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Require Project</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.require.core.model.RequireProject#getName <em>Name</em>}</li>
 *   <li>{@link org.require.core.model.RequireProject#getPath <em>Path</em>}</li>
 *   <li>{@link org.require.core.model.RequireProject#getExistingProjectFullPath <em>Existing Project Full Path</em>}</li>
 *   <li>{@link org.require.core.model.RequireProject#getFullPath <em>Full Path</em>}</li>
 *   <li>{@link org.require.core.model.RequireProject#isProjectExists <em>Project Exists</em>}</li>
 *   <li>{@link org.require.core.model.RequireProject#getDependencies <em>Dependencies</em>}</li>
 *   <li>{@link org.require.core.model.RequireProject#getParentPath <em>Parent Path</em>}</li>
 *   <li>{@link org.require.core.model.RequireProject#getJars <em>Jars</em>}</li>
 * </ul>
 *
 * @see org.require.core.model.ConfigurationPackage#getRequireProject()
 * @model
 * @generated
 */
public interface RequireProject extends EObject {
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
     * @see org.require.core.model.ConfigurationPackage#getRequireProject_Name()
     * @model
     * @generated
     */
	String getName();

	/**
     * Sets the value of the '{@link org.require.core.model.RequireProject#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
	void setName(String value);

	/**
     * Returns the value of the '<em><b>Path</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Path</em>' attribute.
     * @see #setPath(String)
     * @see org.require.core.model.ConfigurationPackage#getRequireProject_Path()
     * @model
     * @generated
     */
	String getPath();

	/**
     * Sets the value of the '{@link org.require.core.model.RequireProject#getPath <em>Path</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Path</em>' attribute.
     * @see #getPath()
     * @generated
     */
	void setPath(String value);

	/**
     * Returns the value of the '<em><b>Existing Project Full Path</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Existing Project Full Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Existing Project Full Path</em>' attribute.
     * @see #setExistingProjectFullPath(String)
     * @see org.require.core.model.ConfigurationPackage#getRequireProject_ExistingProjectFullPath()
     * @model
     * @generated
     */
	String getExistingProjectFullPath();

	/**
     * Sets the value of the '{@link org.require.core.model.RequireProject#getExistingProjectFullPath <em>Existing Project Full Path</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Existing Project Full Path</em>' attribute.
     * @see #getExistingProjectFullPath()
     * @generated
     */
	void setExistingProjectFullPath(String value);

	/**
     * Returns the value of the '<em><b>Full Path</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Full Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Full Path</em>' attribute.
     * @see #setFullPath(String)
     * @see org.require.core.model.ConfigurationPackage#getRequireProject_FullPath()
     * @model
     * @generated
     */
	String getFullPath();

	/**
     * Sets the value of the '{@link org.require.core.model.RequireProject#getFullPath <em>Full Path</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Full Path</em>' attribute.
     * @see #getFullPath()
     * @generated
     */
	void setFullPath(String value);

	/**
     * Returns the value of the '<em><b>Project Exists</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project Exists</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Project Exists</em>' attribute.
     * @see #setProjectExists(boolean)
     * @see org.require.core.model.ConfigurationPackage#getRequireProject_ProjectExists()
     * @model
     * @generated
     */
	boolean isProjectExists();

	/**
     * Sets the value of the '{@link org.require.core.model.RequireProject#isProjectExists <em>Project Exists</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Project Exists</em>' attribute.
     * @see #isProjectExists()
     * @generated
     */
	void setProjectExists(boolean value);

	/**
     * Returns the value of the '<em><b>Dependencies</b></em>' attribute list.
     * The list contents are of type {@link java.lang.String}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dependencies</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Dependencies</em>' attribute list.
     * @see org.require.core.model.ConfigurationPackage#getRequireProject_Dependencies()
     * @model
     * @generated
     */
	EList<String> getDependencies();

	/**
     * Returns the value of the '<em><b>Parent Path</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Parent Path</em>' attribute.
     * @see #setParentPath(String)
     * @see org.require.core.model.ConfigurationPackage#getRequireProject_ParentPath()
     * @model
     * @generated
     */
	String getParentPath();

	/**
     * Sets the value of the '{@link org.require.core.model.RequireProject#getParentPath <em>Parent Path</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Parent Path</em>' attribute.
     * @see #getParentPath()
     * @generated
     */
	void setParentPath(String value);

    /**
     * Returns the value of the '<em><b>Jars</b></em>' attribute list.
     * The list contents are of type {@link java.lang.String}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Jars</em>' attribute list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Jars</em>' attribute list.
     * @see org.require.core.model.ConfigurationPackage#getRequireProject_Jars()
     * @model
     * @generated
     */
    EList<String> getJars();

} // RequireProject
