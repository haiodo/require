/**
 */
package org.eclipse.require.core.model.commands;

import org.eclipse.ecl.core.Command;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Require Find Projects</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.require.core.model.commands.RequireFindProjects#getRoots <em>Roots</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.require.core.model.commands.CommandsPackage#getRequireFindProjects()
 * @model
 * @generated
 */
public interface RequireFindProjects extends Command {
	/**
	 * Returns the value of the '<em><b>Roots</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Roots</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Roots</em>' reference list.
	 * @see org.eclipse.require.core.model.commands.CommandsPackage#getRequireFindProjects_Roots()
	 * @model
	 * @generated
	 */
	EList<EObject> getRoots();

} // RequireFindProjects
