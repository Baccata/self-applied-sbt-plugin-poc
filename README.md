# Self-indulging plugin building

#### So WTF am I looking at ?

This is a POC of a project that builds a plugin that is applied on the project

* The plugin lives in `foo` folder
* The build definition for the plugin is in `foo/build.sbt` (which means you `cd` in that folder and code in isolation)
* The `project/build.sbt` contains a `ProjectRef` value pointing to the `foo` project defined in the `foo` folder. This means that the root's meta build can depend on `foo` and serve its code to the root build (defined in `build.sbt`)
* The `build.sbt` at the root of the project references the `foo` project, meaning it could publish it. This is valid as per SBT's semantics because `foo` is under the current project in the recursive hierarchy of SBT builds.
* You can run `sbt foo/pwd`, meaning that the `pwd` task is run on the `foo` project that defines it.

So you can use plugins in a build that builds the plugin. Additionally, the definition of the plugin is self-contained in the
`foo` folder, which means that SBT (I think) re-uses the compilation of the `foo` project between the root build and the meta-build.
