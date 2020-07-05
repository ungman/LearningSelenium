package io.github.ungman.learnig.seleniumwithtestng.kwd;

import io.github.ungman.learnig.seleniumwithtestng.kwd.getObject.GetterObject;
import io.github.ungman.learnig.seleniumwithtestng.kwd.kwdoperationui.HandleKWDOperation;
import io.github.ungman.learnig.seleniumwithtestng.kwd.kwdoperationui.HandleKWDOperationClick;
import io.github.ungman.learnig.seleniumwithtestng.kwd.kwdoperationui.HandleKWDOperationGotoUrl;
import io.github.ungman.learnig.seleniumwithtestng.kwd.kwdoperationui.HandleKWDOperationSetText;
import org.openqa.selenium.WebDriver;

import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

public class KWDOperationUI implements KWDOperation {
    private Map<String, HandleKWDOperation> operationHandlerMap;
    GetterObject getterObject;

    public KWDOperationUI() {
        operationHandlerMap = new ConcurrentHashMap<>();
        operationHandlerMap.put("click", new HandleKWDOperationClick());
        operationHandlerMap.put("gotourl", new HandleKWDOperationGotoUrl());
        operationHandlerMap.put("settext", new HandleKWDOperationSetText());
        getterObject = new GetterObject();
    }

    @Override
    public void perfom(WebDriver webDriver, Properties properties, String operation, String objectName, String objectType, String value) {
//        System.out.println("perfom: "+operation);
//        if (operationHandlerMap.get(operation.toLowerCase()) != null) {
//            operationHandlerMap.get(operation.toLowerCase()).handle(getterObject.getObject(webDriver, properties, objectName, objectType), value);
//        }
    }
}
