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
        sViewsWithIds.put(R.id.editText7, 1);
        sViewsWithIds.put(R.id.editText, 2);
        sViewsWithIds.put(R.id.editText5, 3);
        sViewsWithIds.put(R.id.editText6, 4);
        sViewsWithIds.put(R.id.button, 5);
        sViewsWithIds.put(R.id.button2, 6);
    }
    // views
    @NonNull
    public final android.widget.Button button;
    @NonNull
    public final android.widget.Button button2;
    @NonNull
    public final android.widget.EditText editText;
    @NonNull
    public final android.widget.EditText editText5;
    @NonNull
    public final android.widget.EditText editText6;
    @NonNull
    public final android.widget.EditText editText7;
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    @Nullable
    private com.example.potensituitionapp.addcourse.AddcourseViewModel mAddcourseViewModel;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentAttendanceBinding(@NonNull androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 0);
        final Object[] bindings = mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds);
        this.button = (android.widget.Button) bindings[5];
        this.button2 = (android.widget.Button) bindings[6];
        this.editText = (android.widget.EditText) bindings[2];
        this.editText5 = (android.widget.EditText) bindings[3];
        this.editText6 = (android.widget.EditText) bindings[4];
        this.editText7 = (android.widget.EditText) bindings[1];
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
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