package thesopt.assignment.hot_yongmin.presentation.ui.main.profile

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import thesopt.assignment.hot_yongmin.R

class HorizontalItemDecoration(private var horizontalMargin : Int, private val spanCount : Int) : RecyclerView.ItemDecoration() {
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
            else if(column==spanCount-1){
                outRect.left=horizontalMargin/4
                outRect.right=horizontalMargin
            }
            else{
                outRect.left=horizontalMargin/4
                outRect.right=horizontalMargin/4
            }
        }
    }
}