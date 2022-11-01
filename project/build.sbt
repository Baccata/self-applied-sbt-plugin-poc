lazy val foo = ProjectRef(file("../foo"), "foo")

dependsOn(foo)
