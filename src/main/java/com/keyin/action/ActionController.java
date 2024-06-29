package com.keyin.action;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ActionController {

    final
    ActionService actionService;

    public ActionController(ActionService actionService) {
        this.actionService = actionService;
    }

    @DeleteMapping("/undo")
    public void undoAction(){
        actionService.undoAction();
    }

    @DeleteMapping("/redo")
    public void redoAction(){
        actionService.redoAction();
    }

}
