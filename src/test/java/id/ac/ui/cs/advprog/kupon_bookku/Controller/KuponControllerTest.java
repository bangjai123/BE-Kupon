//package id.ac.ui.cs.advprog.kupon_bookku.Controller;
//
//import id.ac.ui.cs.advprog.kupon_bookku.controller.KuponController;
//import id.ac.ui.cs.advprog.kupon_bookku.model.Kupon;
//import id.ac.ui.cs.advprog.kupon_bookku.service.KuponService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.concurrent.CompletableFuture;
//
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//public class KuponControllerTest {
//    @Mock
//    private KuponService kuponService;
//
//    @InjectMocks
//    private KuponController kuponController;
//
//    private MockMvc mockMvc;
//
//    @BeforeEach
//    public void setup() {
//        MockitoAnnotations.openMocks(this);
//        mockMvc = MockMvcBuilders.standaloneSetup(kuponController).build();
//    }
//
//    @Test
//    public void testGetAllKupon() throws Exception {
//        Kupon kupon1 = new Kupon();
//        Kupon kupon2 = new Kupon();
//        List<Kupon> kuponList = Arrays.asList(kupon1, kupon2);
//
//        when(kuponService.getAllKupon()).thenReturn(CompletableFuture.completedFuture(kuponList));
//
//        mockMvc.perform(get("/semua-kupon"))
//                .andExpect(status().isOk());
//    }
//}