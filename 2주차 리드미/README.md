## 필수 과제



- [x] Button, TextView 활용

  이름, 나이, MBTI를 Textview에 넣었고, 팔로워 목록 버튼과 레포지토리 목록 버튼은 background와 backgroundTint로 커스텀하기 위해 AppCompatButton을 사용했다.

  <img src="Button, Textview.PNG" width="230">

  

- [x] FollowerRecyclerView, RepositoryRecyclerView 만들기

  두 리사이클러뷰에 해당하는 item xml파일과 리사이클러뷰 어댑터를 만든다.

  

- [x] 각각의 RecyclerView 담고있는 Fragment 2개 만들기

  fragment 두 개를 만들고 homeAcitivity에 fragment container를 넣는다. 각 fragment에 리사이클러뷰를 넣고 layoutmanager를 정해준다.

  

- [x] 각각의 버튼 눌렀을 대 알맞은 Fragment로 전환되게 하기

  fragment를 담는 homeActivity에서 companion object를 다음처럼 만들고

  ```kotlin
  companion object{
          const val FOLLOWER_FRAGMENT = 1
          const val REPO_FRAGMENT = 2
      }
  ```

  fragment 전환을 위한 initTransactionEvent()를 만든다.

  fragmentContainerView의 name 속성으로 FollowerFragment를 이미 넣어주었으므로 home activity가 시작되면 FollowerFragment가 add 된다. (이 방법이 좋지 않지만 나도 모르게 이 방법을 사용한 것을 너무 늦게 깨달아버린 관계로 다음 과제 때 수정하도록 하겠습니다ㅋㅋ)

  팔로워 목록 버튼을 누르면 현재 RepoFragment일 때만 FollowerFragment로 replace한다.

  레포지토리 목록 버튼을 누르면 현재 FollowerFragment일 때만 RepoFragment로 replace한다.

  (생각해보니까 클릭했을 때 클릭 된 버튼 색도 바꾸면 좋았을텐데 안했네요 다음에 추가하겠습니다.)

  ```kotlin
  private fun initTransactionEvent(){
          val followerFragment = FollowerFragment()
          val repoFragment = RepoFragment()
  
          binding.btnFollowerList.setOnClickListener{
              val transaction = supportFragmentManager.beginTransaction()
              if(position== REPO_FRAGMENT){
                  transaction.replace(R.id.fcv_list, followerFragment).commit()
                  position = FOLLOWER_FRAGMENT
              }
          }
          binding.btnRepoList.setOnClickListener{
              val transaction = supportFragmentManager.beginTransaction()
              if(position== FOLLOWER_FRAGMENT){
                  transaction.replace(R.id.fcv_list, repoFragment).commit()
                  position = REPO_FRAGMENT
              }
          }
      }
  ```



- [x] 글씨가 길어지면 뒤에 ...으로 표시되게 하기

  <img src="maxlines, ems.PNG" width="230">

  ```xml
  <TextView
          android:id="@+id/tv_repo_title"
          android:layout_width="wrap_content"
          android:layout_height="wrap_content"
          android:layout_marginTop="10dp"
          android:ellipsize="end"
          android:maxLines="2"
          android:ems="8"
          android:textColor="@color/black"
          android:textSize="15sp"
          android:textStyle="bold"
          android:paddingHorizontal="10dp"
          app:layout_constraintEnd_toEndOf="parent"
          app:layout_constraintStart_toStartOf="parent"
          app:layout_constraintTop_toTopOf="parent"
          tools:text="안드로이드 과제 레포지토리" />
  
      <TextView
          android:id="@+id/tv_repo_description"
          android:layout_width="wrap_content"
          android:layout_height="wrap_content"
          android:layout_marginTop="15dp"
          android:layout_marginBottom="10dp"
          android:ellipsize="end"
          android:maxLines="1"
          android:ems="8"
          android:textSize="15sp"
          android:paddingHorizontal="10dp"
          app:layout_constraintBottom_toBottomOf="parent"
          app:layout_constraintEnd_toEndOf="parent"
          app:layout_constraintStart_toStartOf="parent"
          app:layout_constraintTop_toBottomOf="@id/tv_repo_title"
          tools:text="안드로이드 파트 과제" />
  ```

제목은 maxlines를 2로 줘서 두 줄까지 가능하게 해주고, 설명은 maxlines를 1로 설정해서 한 줄까지 가능하게 해줬다.

ems는 8로 설정해서 한 줄에 8글자까지 가능하게 해주었다. 그리고 ellipsize를 end로 설정해주므로써 8글자가 넘어가면 ...으로 처리하게 해주었다. (근데 제목은 두줄까지 가능인데 두 번째 줄에 8글자가 넘어가는 경우를 안 넣었네요ㅋㅋ)



## 성장과제

- [x] ItemDecoration을 활용해서 리스트간 간격 또는 구분선 주기

  리사이클러뷰의 마진값을 ItemDecoration으로 꾸며봅시다

  먼저 세로 마진을 조절하기 위한 VerticalItemDecoration입니다.

  매개변수로 margin값과 spanCount를 받습니다.

  모든 아이템들의 바텀 마진을 주고 position값과 spanCount값으로 최상단 아이템들만 탑 마진을 추가합니다.

  ```kotlin
  class VerticalItemDecoration(private val verticalMargin : Int, private val spanCount : Int) : RecyclerView.ItemDecoration() {
      override fun getItemOffsets(
          outRect: Rect,
          view: View,
          parent: RecyclerView,
          state: RecyclerView.State
      ) {
          super.getItemOffsets(outRect, view, parent, state)
          val position = parent.getChildAdapterPosition(view)
          if(position < spanCount){
              outRect.top=verticalMargin
          }
          outRect.bottom = verticalMargin
      }
  }
  ```

  

  좀 더 복잡한 가로 마진 조절을 위한 horizontalItemDecoration입니다.

  spancount가 1일 때 &rightarrow; 팔로워 목록은 linear layout이므로 양쪽 마진값을 갖게 준다.

  1이 아닐 때(레포지토리 목록) &rightarrow; 열에 따라 왼쪽과 오른쪽의 마진을 다르게 준다.

  ```kotlin
  class HorizontalItemDecoration(private val horizontalMargin : Int, private val spanCount : Int) : RecyclerView.ItemDecoration() {
      override fun getItemOffsets(
          outRect: Rect,
          view: View,
          parent: RecyclerView,
          state: RecyclerView.State
      ) {
          super.getItemOffsets(outRect, view, parent, state)
          val position = parent.getChildAdapterPosition(view)
          val column = position%spanCount
  
          if(spanCount==1){
              outRect.left=horizontalMargin
              outRect.right=horizontalMargin
          }
          else{
              if(column==0){
                  outRect.left=horizontalMargin
                  outRect.right=horizontalMargin/4
              }
              else{
                  outRect.left=horizontalMargin/4
                  outRect.right=horizontalMargin
              }
          }
      }
  }
  ```

  