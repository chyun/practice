import static com.sun.btrace.BTraceUtils.*;
import com.sun.btrace.annotations.*;
import com.sun.btrace.AnyType;

@BTrace
public class Trace{
   @TLS
   static long beginTime;

   @OnMethod(clazz="cn.service.impl.StoreServiceImpl",method="recordResult",
   location=@Location(Kind.ENTRY))
   public static void begin(){
     beginTime=timeMillis();
   }

   @OnMethod(clazz="cn.service.impl.StoreServiceImpl",method="recordResult",
   location=@Location(Kind.RETURN))
   public static void end(){
     long spendTime=timeMillis()-beginTime;
     println(strcat("spendTime: ",str(spendTime)));
   }

}
