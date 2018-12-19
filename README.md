## MockupModule [![](https://jitpack.io/v/WindSekirun/MockupModule.svg)](https://jitpack.io/#WindSekirun/MockupModule)

[![Kotlin](https://img.shields.io/badge/kotlin-1.2.0-blue.svg)](http://kotlinlang.org)	[![GitHub license](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg?style=flat)](http://www.apache.org/licenses/LICENSE-2.0)

Easy-to-integrate MockupModule for Android, written in [Kotlin](http://kotlinlang.org) 

### Usages
*rootProject/build.gradle*
```	
allprojects {
    repositories {
	    maven { url 'https://jitpack.io' }
    }
}
```

*app/build.gradle*
```
dependencies {
    implementation 'com.github.WindSekirun:MockupModule:1.0.6'
}
```

### Usages
1. put your images to assets (it support subdirectory)
2. making new Activity, with inherit ```MockupActivity```
3. implement all abstract member
4. That's it!

#### Documents
```Kotlin
/**
 * count of images
 *
 * @return count of image files
 */
protected abstract val numberOfItems: Int

/**
 * length of name of file exclude extensions
 *
 * example, if name of file is '003.png', it will be 3
 * @return length of filename
 */
protected abstract val filenameLength: Int

/**
 * name of extensions
 *
 * Constants.EXTENSION_JPG, EXTENSION_PNG, EXTENSION_WEBP or ".jpeg"
 * @return name of extensions
 */
protected abstract val extension: String

/**
 * name of folder which have images to show
 *
 * Constants.EMPTH_PATH or "folder/"
 * @return name of folder
 */
protected abstract val path: String

/**
 * flag when mockupActivity require FullScreen
 *
 * @return flag
 */
protected abstract val requireFullscreen: Boolean
    
```

#### Kotlin
```Kotlin
class KotlinActivity : MockupActivity() {
    override val numberOfItems: Int
        get() = 9
    override val filenameLength: Int
        get() = 3
    override val extension: String
        get() = Constants.EXTENSION_JPG
    override val path: String
        get() = Constants.EMPTY_PATH
    override val requireFullscreen: Boolean
        get() = true
        
}
```

#### Java
```Java
public class MainActivity extends MockupActivity {

    @Override
    protected int getNumberOfItems() {
        return 9;
    }

    @Override
    protected int getFilenameLength() {
        return 3;
    }

    @NotNull
    @Override
    protected String getExtension() {
        return Constants.EXTENSION_JPG;
    }

    @NotNull
    @Override
    protected String getPath() {
        return Constants.EMPTY_PATH;
    }
    
    @Override
    protected boolean getRequireFullscreen() {
        return false;
    }
}
```


### License 
```
Copyright 2017 WindSekirun (DongGil, Seo)

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
