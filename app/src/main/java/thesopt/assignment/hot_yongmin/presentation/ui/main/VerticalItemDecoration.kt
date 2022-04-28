package thesopt.assignment.hot_yongmin.presentation.ui.main

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

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