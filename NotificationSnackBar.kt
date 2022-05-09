import android.view.LayoutInflater
import android.view.View
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.google.android.material.snackbar.Snackbar
import sang.gondroid.calingredientfood.R
import sang.gondroid.calingredientfood.databinding.SnackBarNotificationBinding

/**
 * SnackBar는 final class 이므로 상속이 불가능, SnackBar의 getView()를 통해 View에 액세스해 커스텀하는 방법을 선택
 */
class NotificationSnackBar(view: View, private val message: String) {

    // 여러 instance로 메모리가 소비되지 않도록 SingleTon Pattern으로 구현
    companion object {
        fun make(view: View, message: String) = NotificationSnackBar(view, message)
    }

    private val context = view.context
    // LENGTH_INDEFINITE를 통해 다른 SnackBar가 표시되거나 dismiss하기 전까지 노출
    private val snackBar = Snackbar.make(view, "", Snackbar.LENGTH_INDEFINITE)
    // getView()를 통해 SnackBar의 View에 접근
    private val snackBarLayout = snackBar.view as Snackbar.SnackbarLayout

    private val inflater = LayoutInflater.from(context)
    private val snackBarBinding: SnackBarNotificationBinding = DataBindingUtil.inflate(inflater, R.layout.snack_bar_notification, null, false)

    init {
        initView()
    }

    private fun initView() {
        with(snackBarLayout) {
            // ViewGroup에서 모든 자식 View를 제거
            removeAllViews()
            // 배경을 투명으로 설정
            setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent))
            addView(snackBarBinding.root, 0)
        }
        
        snackBarBinding.notificationInfoTextView.text = message

        // Button 클릭 시 SnackBar 종료
        snackBarBinding.notificationActionButton.setOnClickListener {
            snackBar.dismiss()
        }
    }

    fun show() {
        // SnackBar를 표시
        snackBar.show()
    }
}
