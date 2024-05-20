package com.memeov1.memeov1.controllers;

import com.memeov1.memeov1.services.PostService;
import com.memeov1.memeov1.entities.Comment;
import com.memeov1.memeov1.entities.Conversation;
import com.memeov1.memeov1.entities.DirectMessage;
import com.memeov1.memeov1.entities.Login;
import com.memeov1.memeov1.entities.MemeLike;
import com.memeov1.memeov1.entities.MemeLikePK;
import com.memeov1.memeov1.entities.Post;
import com.memeov1.memeov1.entities.User;
import com.memeov1.memeov1.requests.MemeLikeRequest;
import com.memeov1.memeov1.services.CommentService;
import com.memeov1.memeov1.services.ConversationService;
import com.memeov1.memeov1.services.DMService;
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
@CrossOrigin(origins = "", allowedHeaders = "")
@RequestMapping("/memeo/api")
public class MemeoController {

    public final UserService userService;
    public final PostService postService;
    public final MemeLikeService memeLikeService;
    public final LoginService loginService;
    public final CommentService commentService;
    public final ConversationService conversationService;
    public final DMService dmService;

    public MemeoController(UserService userService, ConversationService conversationService,
            PostService postService, MemeLikeService memeLikeService, LoginService loginService,
            CommentService commentService, DMService dmService) {
        this.userService = userService;
        this.conversationService = conversationService;
        this.postService = postService;
        this.memeLikeService = memeLikeService;
        this.loginService = loginService;
        this.commentService = commentService;
        this.dmService = dmService;
    }

    // login y signin ??????
    // @PostMapping("/signin")
    // public String signin(@RequestParam String param) {
    // return new String();
    // // retornar vista
    // }

    // @GetMapping("/login")
    // public String index(@RequestParam String param) {
    // return new String();
    // }

    // listar post (inicio de usuario)
    // @GetMapping("/feed")
    // public String getFeed(Integer userID) {
    // return new String();
    // }

    // ---------------------- USER
    // ------------------------------------------------------------------------------
    @PostMapping("/createuser")
    public User createUser(@RequestBody User user) {
        return userService.create(user);
    }

    // no necesitamos un getusers

    // incluye create login
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

    // leer un post no sé si lo necesitamos
    // @GetMapping("/getpost/{postID}")
    // public Post getPost(@PathVariable Integer postID) {
    // return postService.read(postID);
    // }

    // no necesitamos actualizar post

    @DeleteMapping("/deletepost/{postID}")
    public String deletePost(@PathVariable Integer postID) {
        return postService.delete(postID);
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

    // no necesitamos un getmemelikes

    // no necesitamos un updatememelike porque o se crea o se borra

    @DeleteMapping("/deletememelike/{userID}/{postID}")
    public String deleteMemeLike(@PathVariable Integer userID, @PathVariable Integer postID) {
        MemeLikePK memeLikePK = new MemeLikePK(postID, userID);
        return memeLikeService.delete(memeLikePK);
    }

    // ---------------------- LOGIN
    // ------------------------------------------------------------------------------
    @PostMapping("/createlogin")
    public Login createLogin(@RequestBody Login login) {
        return loginService.create(login);
    }

    // no necesitamos un getlogins ni un getlogin

    @PutMapping("/updatelogin/{loginID}")
    public Login updateLogin(@PathVariable Integer loginID, @RequestBody Login login) {
        return loginService.update(loginID, login);
    }

    @DeleteMapping("/deletelogin/{loginID}")
    public String deleteLogin(@PathVariable Integer loginID) {
        return loginService.delete(loginID);
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

    // ---------------------- DIRECT MESSAGE
    // --------------------------------------------------------------------------------
    @PostMapping("/createdm")
    public DirectMessage createDirectMessage(@RequestBody DirectMessage directMessage) {
        return dmService.create(directMessage);
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

    // ---------------------- CONVERSATION
    // --------------------------------------------------------------------------------
    @PostMapping("/createconversation")
    public Conversation createConversation(@RequestBody Conversation conversation) {
        // lógica en el service para aumentar el id manualmente
        return conversationService.create(conversation);
    }

    // al crear un dm se tiene que llamar a este método justo después
    @PutMapping("/updateconversation/{conversationID}")
    public Conversation update(@PathVariable Integer conversationID, @RequestBody List<DirectMessage> dms) {
        return conversationService.updateConversation(conversationID, dms);
    }

    @GetMapping("/getconversations/{username}")
    public List<Conversation> getConversations(@PathVariable String username) {
        return conversationService.findConversationsByReceiverUsername(username);
    }

    // no hace falta un get conversation porque al darle a una conversation concreta
    // llamaremos al get dms by conversationID

    @DeleteMapping("/deleteconversation/{conversationID}")
    public String deleteConversation(@PathVariable Integer conversationID) {
        return conversationService.delete(conversationID);
    }

}
