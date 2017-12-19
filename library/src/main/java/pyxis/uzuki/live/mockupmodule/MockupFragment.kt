package pyxis.uzuki.live.mockupmodule

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_mockup.*

import java.io.IOException

class MockupFragment : Fragment() {
    private var page: Int = 0
    private var length: Int = 0
    private var extension: String? = null
    private var path = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        page = arguments.getInt(ARGUMENT_PAGES, 0)
        length = arguments.getInt(ARGUMENT_FILENAME_LENGTH, 0)
        extension = arguments.getString(ARGUMENT_EXTENSION, ".jpg")
        path = arguments.getString(ARGUMENT_PATH, "")
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return LayoutInflater.from(activity).inflate(R.layout.fragment_mockup, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fileName = "$path${page.toString().padStart(length, '0')}$extension"
        val bitmap = getBitmapFromAssets(fileName)
        imgView.setImageBitmap(bitmap)
    }

    @Throws(IOException::class)
    private fun getBitmapFromAssets(fileName: String): Bitmap {
        return BitmapFactory.decodeStream(activity.assets.open(fileName))
    }

    companion object {
        private val ARGUMENT_PAGES = "ece64d11-d187-41f7-8fb7-a2f33a512b14"
        private val ARGUMENT_FILENAME_LENGTH = "e4e366b3-abe0-4a7e-a21e-391546b4846a"
        private val ARGUMENT_EXTENSION = "1d86511c-1353-47f8-9123-3df6cde6de95"
        private val ARGUMENT_PATH = "d34afa14-daa5-433b-add3-393f54b9ca22"

        fun newInstance(page: Int, FILENAME_LENGTH: Int, extension: String, path: String): MockupFragment {
            val fragmentFirst = MockupFragment()
            val args = Bundle()
            args.putInt(ARGUMENT_PAGES, page)
            args.putInt(ARGUMENT_FILENAME_LENGTH, FILENAME_LENGTH)
            args.putString(ARGUMENT_EXTENSION, extension)
            args.putString(ARGUMENT_PATH, path)
            fragmentFirst.arguments = args
            return fragmentFirst
        }
    }
}