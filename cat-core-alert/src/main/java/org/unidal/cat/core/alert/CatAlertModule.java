package org.unidal.cat.core.alert;

import org.unidal.cat.core.alert.engine.AlertEngine;
import org.unidal.helper.Threads;
import org.unidal.initialization.AbstractModule;
import org.unidal.initialization.Module;
import org.unidal.initialization.ModuleContext;
import org.unidal.lookup.annotation.Named;

import com.dianping.cat.CatCoreModule;

@Named(type = Module.class, value = CatAlertModule.ID)
public class CatAlertModule extends AbstractModule {
   public static final String ID = "cat-core-alert";

   @Override
   protected void execute(ModuleContext ctx) throws Exception {
      AlertEngine engine = ctx.lookup(AlertEngine.class);

      Threads.forGroup("cat").start(engine);
   }

   @Override
   public Module[] getDependencies(ModuleContext ctx) {
      return ctx.getModules(CatCoreModule.ID);
   }
}
