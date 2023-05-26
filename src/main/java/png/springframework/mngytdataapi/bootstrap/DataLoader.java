package png.springframework.mngytdataapi.bootstrap;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import png.springframework.mngytdataapi.model.Category;
import png.springframework.mngytdataapi.model.Channel;
import png.springframework.mngytdataapi.model.Profile;
import png.springframework.mngytdataapi.services.CategoryService;
import png.springframework.mngytdataapi.services.ChannelService;
import png.springframework.mngytdataapi.services.ProfileService;


@Component
public class DataLoader implements CommandLineRunner {
    private final ProfileService profileService;
    private final CategoryService categoryService;

    private final ChannelService channelService;

    public DataLoader(ProfileService profileService, CategoryService categoryService, ChannelService channelService) {
        this.profileService = profileService;
        this.categoryService = categoryService;
        this.channelService = channelService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = profileService.findAll().size();

        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        System.out.println("Loading Data..");
        generateProfile("inafsdev@gmail.com");
        generateProfile("png@gmail.com");
    }

    private void generateProfile(String email) {
        Profile profile = Profile.builder()
                .emailId(email)
                .urlThumbnail("www.example.com/email/thumbnail/"+
                        email.substring(0, email.indexOf("@")))
                .build();
        System.out.println("Loaded Profiles.. for " + email);
        profile = this.profileService.save(profile);
        Category science = generateCategory(profile, "science");
        Category math = generateCategory(profile, "math");

        Channel channel1 = generateChannel(science);
        Channel  channel2 = generateChannel(science);
        Channel  channel3 = generateChannel(math);
        Channel  channel4 = generateChannel(math);
    }

    private Category generateCategory(Profile profile, String name) {
        Category category = Category.builder()
                .name(name)
                .urlImage("www.example.com/pic/"+name)
                .profile(profile)
                .build();

        System.out.println("Loaded Categories..");
        return this.categoryService.save(category);
    }
    private Channel generateChannel(Category category) {
         Channel channel = Channel.builder()
                .channelId(RandomStringUtils.randomAlphanumeric(12))
                .title("Channel No # " + RandomUtils.nextInt())
                .category(category)
                .build();

        System.out.println("Loaded Channels..");
         return this.channelService.save(channel);
    }
}
