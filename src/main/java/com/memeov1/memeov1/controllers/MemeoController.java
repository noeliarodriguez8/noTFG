package com.memeov1.memeov1.controllers;

import com.memeov1.memeov1.services.PostService;
import com.memeov1.memeov1.entities.Comment;
import com.memeov1.memeov1.entities.Conversation;
import com.memeov1.memeov1.entities.ConversationPK;
import com.memeov1.memeov1.entities.DirectMessage;
import com.memeov1.memeov1.entities.Follower;
import com.memeov1.memeov1.entities.MemeLike;
import com.memeov1.memeov1.entities.MemeLikePK;
import com.memeov1.memeov1.entities.Post;
import com.memeov1.memeov1.entities.User;
import com.memeov1.memeov1.requests.MemeLikeRequest;
import com.memeov1.memeov1.requests.UserRequest;
import com.memeov1.memeov1.services.CommentService;
import com.memeov1.memeov1.services.ConversationService;
import com.memeov1.memeov1.services.DMService;
import com.memeov1.memeov1.services.FollowerService;
import com.memeov1.memeov1.services.LoginService;
import com.memeov1.memeov1.services.MemeLikeService;
import com.memeov1.memeov1.services.UserService;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/memeo/api")
public class MemeoController {

    public final UserService userService;
    public final PostService postService;
    public final MemeLikeService memeLikeService;
    public final LoginService loginService;
    public final CommentService commentService;
    public final ConversationService conversationService;
    public final DMService dmService;
    public final FollowerService followerService;

    public MemeoController(UserService userService, ConversationService conversationService,
            PostService postService, MemeLikeService memeLikeService, LoginService loginService,
            CommentService commentService, DMService dmService, FollowerService followerService) {
        this.userService = userService;
        this.conversationService = conversationService;
        this.postService = postService;
        this.memeLikeService = memeLikeService;
        this.loginService = loginService;
        this.commentService = commentService;
        this.dmService = dmService;
        this.followerService = followerService;
    }

    // ---------------------- USER
    // ------------------------------------------------------------------------------
    // incluye create login
    @PostMapping("/createuser")
    public User createUser(@RequestBody UserRequest userRequest) {
        return userService.create(userRequest.getUser(), userRequest.getPassword());
    }

    // no necesitamos un getusers

    @GetMapping("/getuser/{userID}")
    public User getUser(@PathVariable Integer userID) {
        return userService.read(userID);
    }

    // incluye update login
    @PutMapping("/updateuser/{userID}")
    public User updateUser(@PathVariable Integer userID, @RequestBody User user) {
        return userService.update(userID, user);
    }

    // incluye delete login
    @DeleteMapping("/deleteuser/{userID}")
    public String deleteUser(@PathVariable Integer userID) {
        return userService.delete(userID);
    }

    // ---------------------- LOGIN -> METER LOGIN EN CRUD USER
    // ------------------------------------------------------------------------------
    // @PostMapping("/createlogin")
    // public Login createLogin(@RequestBody Login login) {
    // return loginService.create(login);
    // }

    // no necesitamos un getlogins ni un getlogin

    // @PutMapping("/updatelogin/{loginID}")
    // public Login updateLogin(@PathVariable Integer loginID, @RequestBody Login
    // login) {
    // return loginService.update(loginID, login);
    // }

    // @DeleteMapping("/deletelogin/{loginID}")
    // public String deleteLogin(@PathVariable Integer loginID) {
    // return loginService.delete(loginID);
    // }

    // ---------------------- POST
    // --------------------------------------------------------------------------------
    @PostMapping("/createpost")
    public Post createPost(@RequestBody Post post) {
        return postService.create(post);
    }

    @GetMapping("/getposts/{userID}")
    public List<Post> getPosts(@PathVariable Integer userID) {
        return postService.getPostsForCurrentUser(userID);
    }

    // leer un post no hace falta
    // lo sacamos directamente del front cuando estemos en la pantalla de un usuario
    // a través de su lista de posts

    // no necesitamos actualizar post

    @DeleteMapping("/deletepost/{postID}")
    public String deletePost(@PathVariable Integer postID) {
        return postService.delete(postID);
    }

    // ---------------------- FOLLOWER
    // ------------------------------------------------------------------------------
    @PostMapping("/createfollower")
    public Follower createFollower(@RequestBody Follower follower) {
        return followerService.create(follower);
    }

    // getfollowers y getfollowing no hacen falta porque se sacan de las propiedades
    // followers y following de User directamente

    @DeleteMapping("/deletefollower/{fromUserID}/{toUserID}")
    public String deleteFollower(@PathVariable Integer fromUserID, @PathVariable Integer toUserID) {

        return followerService.delete(fromUserID, toUserID);
    }

    // ---------------------- MEMELIKE
    // ---------------------------------------------------------------------------------------------
    @PostMapping(value = "/creatememelike", consumes = MediaType.APPLICATION_JSON_VALUE)
    // lo de consumes es opcional
    public MemeLike createMemeLike(@RequestBody MemeLikeRequest memeLikeRequest) {
        MemeLikePK memeLikePK = new MemeLikePK(memeLikeRequest.getPost().getPostID(),
                memeLikeRequest.getUser().getUserID());
        MemeLike memeLike = new MemeLike(memeLikeRequest.getPost(), memeLikeRequest.getUser());
        memeLike.setMemeLikePK(memeLikePK);
        return memeLikeService.create(memeLike);
    }

    // crear método para buscar si un post tiene el memelike del usuario registrado

    // no necesitamos un getmemelikes

    // no necesitamos un updatememelike porque o se crea o se borra

    @DeleteMapping("/deletememelike/{userID}/{postID}")
    public String deleteMemeLike(@PathVariable Integer userID, @PathVariable Integer postID) {
        MemeLikePK memeLikePK = new MemeLikePK(postID, userID);
        return memeLikeService.delete(memeLikePK);
    }

    // ---------------------- COMMENT
    // --------------------------------------------------------------------------------
    @PostMapping("/createcomment")
    public Comment createComment(@RequestBody Comment comment) {
        return commentService.create(comment);
    }

    @GetMapping("/getcomments/{postID}")
    public List<Comment> getComments(@PathVariable Integer postID) {
        return commentService.getCommentsFromPost(postID);
    }

    // no necesitamos leer un comentario

    // no necesitamos actualizar comentario

    @DeleteMapping("/deletecomment/{commentID}")
    public String deleteComment(@PathVariable Integer commentID) {
        return commentService.delete(commentID);
    }

    // ---------------------- CONVERSATION
    // --------------------------------------------------------------------------------
    @PostMapping("/createconversation")
    public Conversation createConversation(@RequestBody Conversation conversation) {
        // lógica en el service para aumentar el id manualmente
        return conversationService.create(conversation);
    }

    // al crear un dm se tiene que llamar a este método justo después
    // @PutMapping("/updateconversation/{conversationID}")
    // public Conversation update(@PathVariable Integer conversationID, @RequestBody
    // List<DirectMessage> dms) {
    // return conversationService.updateConversation(conversationID, dms);
    // }

    // secundario, solo si tenemos tiempo
    // @GetMapping("/searchconversations/{username}")
    // public List<Conversation> searchConversations(@PathVariable String username)
    // {
    // return conversationService.findConversationsByReceiverUsername(username);
    // }

    @GetMapping("/getconversations/{userID}")
    public List<Conversation> getConversations(@PathVariable Integer userID) {
        return conversationService.findConversationsByRegisteredUser(userID);
    }

    // no hace falta un get conversation porque al darle a una conversation concreta
    // llamaremos al get dms by conversationID

    @DeleteMapping("/deleteconversation/{conversationID}")
    public String deleteConversation(@PathVariable Integer conversationID) {
        return conversationService.delete(conversationID);
    }

    // ---------------------- DIRECT MESSAGE
    // --------------------------------------------------------------------------------
    // @PostMapping("/createdm/{conversationID}")
    // public Conversation createDirectMessage(@PathVariable Integer conversationID,
    // @RequestBody DirectMessage directMessage) {
    // dmService.create(directMessage);
    // Conversation conversation =
    // conversationService.updateConversation(conversationID, directMessage);
    // return conversation;
    // }

    @PostMapping("/createdm/{conversationID}/{starterUserID}/{receiverUserID}")
    public Conversation createDirectMessage(@PathVariable Integer conversationID, @PathVariable Integer starterUserID,
            @PathVariable Integer receiverUserID, @RequestBody DirectMessage directMessage) {
        ConversationPK cpk = new ConversationPK(conversationID, starterUserID, receiverUserID);
        directMessage.setConversation(new Conversation(cpk));
        dmService.create(directMessage);
        Conversation conversation = conversationService.updateConversation(conversationID, directMessage);
        return conversation;
    }

    @GetMapping("/getdms/{conversationID}")
    public List<DirectMessage> getDMs(@PathVariable Integer conversationID) {
        return dmService.getDMsFromConversation(conversationID);
    }

    // no necesitamos leer un dm

    // no necesitamos actualizar dm

    @DeleteMapping("/deletedm/{messageID}")
    public String deleteDM(@PathVariable Integer messageID) {
        return dmService.delete(messageID);
    }

}
