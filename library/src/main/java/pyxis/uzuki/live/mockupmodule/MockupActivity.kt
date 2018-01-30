package pyxis.uzuki.live.mockupmodule

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_mockup.*

abstract class MockupActivity : AppCompatActivity() {

    /**
     * count of images
     *
     * @return size of image files
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.MockupTheme)

        if (requireFullscreen) {
            window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        }

        setContentView(R.layout.activity_mockup)

        val pagerAdapter = MockupFragmentAdapter(supportFragmentManager)
        viewPager.adapter = pagerAdapter
    }

    private inner class MockupFragmentAdapter internal constructor(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

        override fun getCount(): Int {
            return numberOfItems
        }

        override fun getItem(position: Int): Fragment {
            return MockupFragment.newInstance(position, filenameLength, extension, path)
        }
    }
}
