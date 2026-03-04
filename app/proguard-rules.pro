-repackageclasses
-ignorewarnings
-dontnote
-dontwarn
-dontusemixedcaseclassnames
-dontskipnonpubliclibraryclasses
-verbose
-dontoptimize
-dontpreverify

# Keep filenames and line numbers for stack traces
#-keepattributes SourceFile,LineNumberTable

# Code obfuscation
-keep class com.hs.gen.pro.MainActivity.** { *; }
-keep class com.hs.gen.pro.AESCrypt.** { *; }
-keep class com.hs.gen.pro.util.HSCryptA.** { *; }
-keep class com.hs.gen.pro.util.HSCryptB.** { *; }
-keep class com.hs.gen.pro.util.HSCryptC.** { *; }
-keep class com.hs.gen.pro.util.HSCryptD.** { *; }
-keep class com.hs.gen.pro.util.HSCryptE.** { *; }
-keep class com.hs.gen.pro.dialog.ServerDialog.** { *; }
-keep class com.hs.gen.pro.dialog.** { *; }
-keep class com.hs.gen.pro.util.** { *; }