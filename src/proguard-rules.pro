# Add any ProGuard configurations specific to this
# extension here.

-keep public class com.sunny.ScrollHandler.ScrollHandler {
    public *;
 }
-keeppackagenames gnu.kawa**, gnu.expr**

-optimizationpasses 4
-allowaccessmodification
-mergeinterfacesaggressively

-repackageclasses 'com/sunny/ScrollHandler/repack'
-flattenpackagehierarchy
-dontpreverify
