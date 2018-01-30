package pyxis.uzuki.live.mockupmoduledemo

import pyxis.uzuki.live.mockupmodule.Constants
import pyxis.uzuki.live.mockupmodule.MockupActivity

/**
 * MockupModule
 * Class: KotlinActivity
 * Created by Pyxis on 2017-12-19.
 *
 * Description:
 */

class KotlinActivity : MockupActivity() {
    override val requireFullscreen: Boolean
        get() = true
    override val numberOfItems: Int
        get() = 9
    override val filenameLength: Int
        get() = 3
    override val extension: String
        get() = Constants.EXTENSION_JPG
    override val path: String
        get() = Constants.EMPTY_PATH
}