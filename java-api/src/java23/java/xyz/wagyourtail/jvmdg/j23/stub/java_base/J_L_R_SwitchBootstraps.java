package xyz.wagyourtail.jvmdg.j23.stub.java_base;

import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.InvokeDynamicInsnNode;
import org.objectweb.asm.tree.MethodNode;
import xyz.wagyourtail.jvmdg.version.Modify;
import xyz.wagyourtail.jvmdg.version.Ref;

public class J_L_R_SwitchBootstraps {

    // java 23+ uses common supertype instead of Object, and <23 doesn't cast the method handle in the callsite
    @Modify(ref = @Ref(value = "java/lang/runtime/SwitchBootstraps", member = "typeSwitch", desc = "(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;"))
    public static void makeTypeSwitch(MethodNode mnode, int i, ClassNode cnode, boolean noSynthetic) {
        InvokeDynamicInsnNode indy = (InvokeDynamicInsnNode) mnode.instructions.get(i);
        indy.desc = "(Ljava/lang/Object;I)I";
    }

}
