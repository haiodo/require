/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.require.config.model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.require.config.model.Configuration#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.require.config.model.Configuration#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.eclipse.require.config.model.Configuration#getProjects <em>Projects</em>}</li>
 *   <li>{@link org.eclipse.require.config.model.Configuration#getFilePath <em>File Path</em>}</li>
 *   <li>{@link org.eclipse.require.config.model.Configuration#getRootFolder <em>Root Folder</em>}</li>
 *   <li>{@link org.eclipse.require.config.model.Configuration#getStoredFileID <em>Stored File ID</em>}</li>
 *   <li>{@link org.eclipse.require.config.model.Configuration#getLastSynchronization <em>Last Synchronization</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.require.config.model.ModelPackage#getConfiguration()
 * @model
 * @generated
 */
public interface Configuration extends EObject {

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
	 * @see org.eclipse.require.config.model.ModelPackage#getConfiguration_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.require.config.model.Configuration#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enabled</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled</em>' attribute.
	 * @see #setEnabled(boolean)
	 * @see org.eclipse.require.config.model.ModelPackage#getConfiguration_Enabled()
	 * @model
	 * @generated
	 */
	boolean isEnabled();

	/**
	 * Sets the value of the '{@link org.eclipse.require.config.model.Configuration#isEnabled <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled</em>' attribute.
	 * @see #isEnabled()
	 * @generated
	 */
	void setEnabled(boolean value);

	/**
	 * Returns the value of the '<em><b>Projects</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Projects</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Projects</em>' attribute.
	 * @see #setProjects(int)
	 * @see org.eclipse.require.config.model.ModelPackage#getConfiguration_Projects()
	 * @model
	 * @generated
	 */
	int getProjects();

	/**
	 * Sets the value of the '{@link org.eclipse.require.config.model.Configuration#getProjects <em>Projects</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Projects</em>' attribute.
	 * @see #getProjects()
	 * @generated
	 */
	void setProjects(int value);

	/**
	 * Returns the value of the '<em><b>File Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>File Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>File Path</em>' attribute.
	 * @see #setFilePath(String)
	 * @see org.eclipse.require.config.model.ModelPackage#getConfiguration_FilePath()
	 * @model
	 * @generated
	 */
	String getFilePath();

	/**
	 * Sets the value of the '{@link org.eclipse.require.config.model.Configuration#getFilePath <em>File Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>File Path</em>' attribute.
	 * @see #getFilePath()
	 * @generated
	 */
	void setFilePath(String value);

	/**
	 * Returns the value of the '<em><b>Root Folder</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Root Folder</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Root Folder</em>' attribute.
	 * @see #setRootFolder(String)
	 * @see org.eclipse.require.config.model.ModelPackage#getConfiguration_RootFolder()
	 * @model
	 * @generated
	 */
	String getRootFolder();

	/**
	 * Sets the value of the '{@link org.eclipse.require.config.model.Configuration#getRootFolder <em>Root Folder</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Root Folder</em>' attribute.
	 * @see #getRootFolder()
	 * @generated
	 */
	void setRootFolder(String value);

	/**
	 * Returns the value of the '<em><b>Stored File ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stored File ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stored File ID</em>' attribute.
	 * @see #setStoredFileID(String)
	 * @see org.eclipse.require.config.model.ModelPackage#getConfiguration_StoredFileID()
	 * @model
	 * @generated
	 */
	String getStoredFileID();

	/**
	 * Sets the value of the '{@link org.eclipse.require.config.model.Configuration#getStoredFileID <em>Stored File ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stored File ID</em>' attribute.
	 * @see #getStoredFileID()
	 * @generated
	 */
	void setStoredFileID(String value);

	/**
	 * Returns the value of the '<em><b>Last Synchronization</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Synchronization</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Synchronization</em>' attribute.
	 * @see #setLastSynchronization(long)
	 * @see org.eclipse.require.config.model.ModelPackage#getConfiguration_LastSynchronization()
	 * @model
	 * @generated
	 */
	long getLastSynchronization();

	/**
	 * Sets the value of the '{@link org.eclipse.require.config.model.Configuration#getLastSynchronization <em>Last Synchronization</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Synchronization</em>' attribute.
	 * @see #getLastSynchronization()
	 * @generated
	 */
	void setLastSynchronization(long value);
} // Configuration
