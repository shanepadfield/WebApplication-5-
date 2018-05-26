/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Item;
import model.ItemDB;
import model.ItemRating;
import model.UserDB;
import model.User;
import model.UserProfile;

/**
 *
 * @author Shane
 */
@WebServlet(name = "ProfileController", urlPatterns = {"/ProfileController"})
public class ProfileController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ItemRating itemRating = new ItemRating();
        ArrayList<Item> items = ItemDB.getItems();
        ArrayList<User> users = UserDB.getUsers();
        List<ItemRating> userFavorites = new ArrayList<>();
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(0);

        String action = request.getParameter("action");
        String itemCode = request.getParameter("itemCode");
        String url = "/mySavedContent.jsp";

        //User and user profile in the session
        User user = (User) session.getAttribute("theUser");
        if (user == null) user = UserDB.getUser("0");
        UserProfile userProfile = (UserProfile) session.getAttribute("currentProfile");
        
        //Sign in and sign out functions
        if (action != null && action.equals("signout")) {
            session.removeAttribute("currentProfile");
            session.removeAttribute("theUser");
            user = null;
            url = "/index.jsp";
        }
        if (action != null && (action.equals("signin"))) {
            userProfile = new UserProfile(user);
            session.setAttribute("theUser", user);
            session.setAttribute("currentProfile", userProfile);
            if (action.equals("signin")) url = "/mySavedContent.jsp";
        }
        if (userProfile != null){
            userFavorites = userProfile.getItems();
        }
        if (userProfile != null) {
            if (action != null && !action.equals("")) {
                
                if (action.equals("favorite")) {
                    url = "/mySavedContent.jsp";
                    for (Item i : items)
                        if (i.getItemCode().equals(itemCode)) 
                            userProfile.addItem(new ItemRating(i, 0, false));
                }
                
                if (action.equals("delete")) {
                    url = "/mySavedContent.jsp";
                    for (ItemRating i : userFavorites)
                        if (i.getItem().getItemCode().equals(itemCode)) 
                            itemRating = i;
                    userProfile.removeItem(itemRating);
                }
                
                if (action.equals("update") || action.equals("rate")) {
                    url = "/feedback.jsp";
                    for (Item i : items)
                        if (i.getItemCode().equals(itemCode)) {
                            request.setAttribute("item", i);
                            if (userProfile.containsItem(i)) {
                                request.setAttribute("userRating", userProfile.getItemRating(i));
                                request.setAttribute("listened", userProfile.getListened(i));
                            }
                        }
                }
                
                if (action.equals("confirmUpdate")) {
                    url = "/mySavedContent.jsp";
                    
                    Item item = null;
                    for (Item i : items)
                        if (i.getItemCode().equals(itemCode))
                            item = i;
                    
                    String userRatingString = request.getParameter("userRating");
                    int userRating = 0;
                    for (int x = 1; x < 6; x++) 
                            if (userRatingString.equals(Integer.toString(x))) userRating = x;
                    
                    String listenedString = request.getParameter("listened");
                    boolean listened = listenedString.equals("true");
                    
                    boolean updated = false;
                    for (ItemRating i : userFavorites)
                        if (i.getItem().getItemCode().equals(itemCode)) {
                            i.setRating(userRating);
                            i.setMadeIt(listened);
                            updated = true;
                        }
                    
                    if (!updated) 
                        userProfile.addItem(new ItemRating(item, userRating, listened));
                        
                }
            }
        } 
        
        session.setAttribute("theUser", user);
        
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
