# CustomSnackBar

SnackBar는 디바이스의 화면 하단에 작업에 대한 간단한 피드백 또는 메시지를 제공할 때 사용하며 화면의 가장 위에 나타나며 한 번에 하나씩 표시할 수 있습니다.

SnackBar는 일반적으로 시간 초과 또는 화면의 다른 곳에서 사용자와 상호 작용 시 자동으로 사라지며 화면 밖으로 스와이프 할 수 있습니다.

중요한 점은 SnackBar는 final class 이므로 상속이 불가능하기 때문에 SnackBar의 getView()를 통해 View에 액세스해 커스텀하는 방법으로 구현해야합니다.

<br>

1. NotificationSnackBar를 구현하기 위해 사용하기 위해선 DataBinding 종속성을 추가와 Strings 리소스 파일에 same_value_exists에 대한 변수가 선언되어야 합니다.

2. 사용법 : NotificationSnackBar를 화면에 표시하기 위해서 표시하고자 하는 부모 View와 문자열을 인자로 전달해야 합니다.
```
NotificationSnackBar.make(
                                requireView(),
                                resources.getString(R.string.same_value_exists)
                            ).show()
```
