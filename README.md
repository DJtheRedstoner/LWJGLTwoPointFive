# LWJGLTwoPointFive
An example of running LWJGL3 alongside LWJGL2 in Minecraft.

**IMPORTANT: This does NOT make minecraft use LWJGL3 for rendering, it simply allows
using LWJGL3 bindings alongside LWJGL2**

## How it works
Excluding opengl classes, the only classes the conflicts between lwjgl2 and 3
are `org.lwjgl.BufferUtils` and `org.lwjgl.PointerBuffer`. Thankfully, those classes
have no native methods so simply relocating them just works. After that, most things work.
LWJGL2 jars are Sealed, however simply removing `org.lwjgl.` from transformer exclusions
gets around this and lets you transform lwjgl classes (which is needed in some cases).
In the case of nanovg bindings, [NanoVGGLConfig][NanoVGGLConfig] needs to be able to fetch
function pointers so a [transformer][ClassTransformer] and 
[custom FunctionProvider][Lwjgl2FunctionProvider] is needed.

## TODO:
- gradle plugin/task to merge and relocate sources
- test out more bindings

[NanoVGGLConfig]: https://github.com/LWJGL/lwjgl3/blob/master/modules/lwjgl/nanovg/src/main/java/org/lwjgl/nanovg/NanoVGGLConfig.java
[ClassTransformer]: src/main/java/me/djtheredstoner/lwjgl/plugin/ClassTransformer.java
[Lwjgl2FunctionProvider]: src/main/java/me/djtheredstoner/lwjgl/Lwjgl2FunctionProvider.java