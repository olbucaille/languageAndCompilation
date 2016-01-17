import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

import Business.ArrayCustom;
import Business.ObjectToCompile;
import Business.Observable;
import Business.Observateur;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

//observateur concret
public class Compiler extends ClassLoader implements Observateur,Opcodes {
	byte[] bytes ;
	String className;
	
	@Override
	public void actualiser(String className,ObjectToCompile otc) {
		// TODO Auto-generated method stub
		this.className=className;
		
	}

	
	public void compile() {
		
        int [] test = new int[4] ;
  
        
        // class header
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        cw.visit(V1_1, ACC_PUBLIC, this.className, null, "java/lang/Object",
                new String[] { Expression.class.getName() });
        //add attribute ;
        
        

        // default public constructor
        MethodVisitor mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null,
                null);
        mv.visitVarInsn(ALOAD, 0);
        mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V",
                false);
        mv.visitInsn(RETURN);
        mv.visitMaxs(1, 1);
        mv.visitEnd();
        // FIN default public constructor
        


        bytes = cw.toByteArray();
        
        FileOutputStream fos;
		try {
			fos = new FileOutputStream(this.className +".class");		
	        fos.write(bytes);
	        fos.close();
        
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
       
	}
	
	
	
	public void instantiates(){
		 


		 Class<?> expClass = defineClass(this.className, bytes, 0, bytes.length);
	        // instantiates this compiled expression class...
	        try {
				Expression iexp = (Expression) expClass.newInstance();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

        // ... and uses it to evaluate exp(0) to exp(9)
        /*for (int i = 0; i < 10; ++i) {
            int val = iexp.addInt(i, 0) ;
            System.out.println(i +" + " + i + " = " + val);
        }*/
	}
	
	
	
	/**
	 * An addition expression.
	 */

    void compileAdd(final MethodVisitor mv) {
        //  adds an instruction to add the two values

        mv.visitInsn(IADD);
    }


	/**
	 * A multiplication expression.
	 */

    void compileMul(final MethodVisitor mv) {
        //  adds an instruction to multiply the two values

        mv.visitInsn(IMUL);
    }


	
}

