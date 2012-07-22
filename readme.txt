Require is a project import and configuration tool.
Tool itself is a list of ecl commands to perform required operations.

* As User I do following.
require-git clone cvs.xored.com/git/q7 /Users/Develop/git/q7 # Create and checkout master from git repository to appropriate folder
require-apply q7

with [require-git-root q7 | require-find-projects ] {
	require-import -path [emit "core" "launching"] | require-apply-workingSet "q7.core"
	require-import -path "runtime" | require-assign-ws "q7.runtime"
	require-import -matches "*x5*" | require-assign-ws "q7.x5"
}


TODO:
1. require-git -> ecl command to various git commands wrapper based on egit,jgit
2. require-git-root -> ecl command to obtain ecl root folder based on git repository name