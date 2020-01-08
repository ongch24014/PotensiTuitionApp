package com.example.potensituitionapp.databinding;
import com.example.potensituitionapp.R;
import com.example.potensituitionapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentAttendanceBinding extends androidx.databinding.ViewDataBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.txtNum1, 1);
        sViewsWithIds.put(R.id.txtNum2, 2);
        sViewsWithIds.put(R.id.txtNum3, 3);
        sViewsWithIds.put(R.id.txtNum4, 4);
    }
    // views
    @NonNull
    private final android.widget.ScrollView mboundView0;
    @NonNull
    public final android.widget.EditText txtNum1;
    @NonNull
    public final android.widget.EditText txtNum2;
    @NonNull
    public final android.widget.EditText txtNum3;
    @NonNull
    public final android.widget.EditText txtNum4;
    // variables
    @Nullable
    private com.example.potensituitionapp.addcourse.AddcourseViewModel mAddcourseViewModel;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentAttendanceBinding(@NonNull androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 0);
        final Object[] bindings = mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds);
        this.mboundView0 = (android.widget.ScrollView) bindings[0];
        this.mboundView0.setTag(null);
        this.txtNum1 = (android.widget.EditText) bindings[1];
        this.txtNum2 = (android.widget.EditText) bindings[2];
        this.txtNum3 = (android.widget.EditText) bindings[3];
        this.txtNum4 = (android.widget.EditText) bindings[4];
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.addcourseViewModel == variableId) {
            setAddcourseViewModel((com.example.potensituitionapp.addcourse.AddcourseViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setAddcourseViewModel(@Nullable com.example.potensituitionapp.addcourse.AddcourseViewModel AddcourseViewModel) {
        this.mAddcourseViewModel = AddcourseViewModel;
    }
    @Nullable
    public com.example.potensituitionapp.addcourse.AddcourseViewModel getAddcourseViewModel() {
        return mAddcourseViewModel;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static FragmentAttendanceBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static FragmentAttendanceBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable androidx.databinding.DataBindingComponent bindingComponent) {
        return androidx.databinding.DataBindingUtil.<FragmentAttendanceBinding>inflate(inflater, com.example.potensituitionapp.R.layout.fragment_attendance, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static FragmentAttendanceBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static FragmentAttendanceBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable androidx.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.example.potensituitionapp.R.layout.fragment_attendance, null, false), bindingComponent);
    }
    @NonNull
    public static FragmentAttendanceBinding bind(@NonNull android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static FragmentAttendanceBinding bind(@NonNull android.view.View view, @Nullable androidx.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/fragment_attendance_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new FragmentAttendanceBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): addcourseViewModel
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}