package com.fourteener.megaserver;

public class Properties {
public static String server = "spawn-protection=0\n" + 
		"max-tick-time=60000\n" + 
		"query.port=25565\n" + 
		"generator-settings=\n" + 
		"force-gamemode=false\n" + 
		"allow-nether=true\n" + 
		"enforce-whitelist=false\n" + 
		"gamemode=survival\n" + 
		"broadcast-console-to-ops=true\n" + 
		"enable-query=false\n" + 
		"player-idle-timeout=0\n" + 
		"difficulty=peaceful\n" + 
		"spawn-monsters=true\n" + 
		"broadcast-rcon-to-ops=true\n" + 
		"op-permission-level=4\n" + 
		"pvp=true\n" + 
		"snooper-enabled=true\n" + 
		"level-type=default\n" + 
		"hardcore=false\n" + 
		"enable-command-block=true\n" + 
		"max-players=20\n" + 
		"network-compression-threshold=256\n" + 
		"resource-pack-sha1=\n" + 
		"max-world-size=29999984\n" + 
		"function-permission-level=2\n" + 
		"rcon.port=25575\n" + 
		"server-port=25565\n" + 
		"debug=false\n" + 
		"server-ip=\n" + 
		"spawn-npcs=true\n" + 
		"allow-flight=false\n" +
		"view-distance=10\n" + 
		"resource-pack=\n" + 
		"spawn-animals=true\n" + 
		"white-list=true\n" + 
		"rcon.password=\n" + 
		"generate-structures=true\n" + 
		"online-mode=true\n" + 
		"max-build-height=256\n" + 
		"level-seed=\n" + 
		"use-native-transport=true\n" + 
		"prevent-proxy-connections=false\n" + 
		"motd=The Mapmaking Megaserver\n" + 
		"enable-rcon=false\n";

public static String spigot = "# This is the main configuration file for Spigot.\n" + 
		"# As you can see, there's tons to configure. Some options may impact gameplay, so use\n" + 
		"# with caution, and make sure you know what each option does before configuring.\n" + 
		"# For a reference for any variable inside this file, check out the Spigot wiki at\n" + 
		"# http://www.spigotmc.org/wiki/spigot-configuration/\n" + 
		"# \n" + 
		"# If you need help with the configuration or have any questions related to Spigot,\n" + 
		"# join us at the IRC or drop by our forums and leave a post.\n" + 
		"# \n" + 
		"# IRC: #spigot @ irc.spi.gt ( http://www.spigotmc.org/pages/irc/ )\n" + 
		"# Forums: http://www.spigotmc.org/\n" + 
		"\n" + 
		"config-version: 12\n" + 
		"settings:\n" + 
		"  debug: false\n" + 
		"  save-user-cache-on-stop-only: false\n" + 
		"  bungeecord: false\n" + 
		"  user-cache-size: 1000\n" + 
		"  moved-wrongly-threshold: 0.0625\n" + 
		"  moved-too-quickly-multiplier: 10.0\n" + 
		"  log-villager-deaths: true\n" + 
		"  timeout-time: 60\n" + 
		"  restart-on-crash: true\n" + 
		"  restart-script: ./start.sh\n" + 
		"  netty-threads: 4\n" + 
		"  sample-count: 12\n" + 
		"  player-shuffle: 0\n" + 
		"  attribute:\n" + 
		"    maxHealth:\n" + 
		"      max: 2048.0\n" + 
		"    movementSpeed:\n" + 
		"      max: 2048.0\n" + 
		"    attackDamage:\n" + 
		"      max: 2048.0\n" + 
		"messages:\n" + 
		"  whitelist: Please type \"op <username>\" into the console\n" + 
		"  unknown-command: Unknown command. Type \"/help\" for help.\n" + 
		"  server-full: The server is full!\n" + 
		"  outdated-client: Outdated client! Please use {0}\n" + 
		"  outdated-server: Outdated server! I'm still on {0}\n" + 
		"  restart: Server is restarting\n" + 
		"commands:\n" + 
		"  replace-commands:\n" + 
		"  - setblock\n" + 
		"  - summon\n" + 
		"  - testforblock\n" + 
		"  - tellraw\n" + 
		"  log: true\n" + 
		"  tab-complete: 0\n" + 
		"  send-namespaced: true\n" + 
		"  spam-exclusions:\n" + 
		"  - /skill\n" + 
		"  silent-commandblock-console: false\n" + 
		"advancements:\n" + 
		"  disable-saving: false\n" + 
		"  disabled:\n" + 
		"  - minecraft:story/disabled\n" + 
		"stats:\n" + 
		"  disable-saving: false\n" + 
		"  forced-stats: {}\n" + 
		"world-settings:\n" + 
		"  default:\n" + 
		"    max-entity-collisions: 2\n" + 
		"    verbose: true\n" + 
		"    mob-spawn-range: 6\n" + 
		"    hopper-amount: 1\n" + 
		"    dragon-death-sound-radius: 0\n" + 
		"    seed-village: 10387312\n" + 
		"    seed-desert: 14357617\n" + 
		"    seed-igloo: 14357618\n" + 
		"    seed-jungle: 14357619\n" + 
		"    seed-swamp: 14357620\n" + 
		"    seed-monument: 10387313\n" + 
		"    seed-shipwreck: 165745295\n" + 
		"    seed-ocean: 14357621\n" + 
		"    seed-outpost: 165745296\n" + 
		"    seed-slime: 987234911\n" + 
		"    max-tnt-per-tick: 20\n" + 
		"    view-distance: default\n" + 
		"    enable-zombie-pigmen-portal-spawns: true\n" + 
		"    item-despawn-rate: 6000\n" + 
		"    arrow-despawn-rate: 1200\n" + 
		"    trident-despawn-rate: 1200\n" + 
		"    wither-spawn-sound-radius: 0\n" + 
		"    hanging-tick-frequency: 100\n" + 
		"    zombie-aggressive-towards-villager: true\n" + 
		"    nerf-spawner-mobs: false\n" + 
		"    growth:\n" + 
		"      cactus-modifier: 10\n" + 
		"      cane-modifier: 10\n" + 
		"      melon-modifier: 10\n" + 
		"      mushroom-modifier: 10\n" + 
		"      pumpkin-modifier: 10\n" + 
		"      sapling-modifier: 10\n" + 
		"      beetroot-modifier: 10\n" + 
		"      carrot-modifier: 10\n" + 
		"      potato-modifier: 10\n" + 
		"      wheat-modifier: 10\n" + 
		"      netherwart-modifier: 10\n" + 
		"      vine-modifier: 10\n" + 
		"      cocoa-modifier: 10\n" + 
		"      bamboo-modifier: 10\n" + 
		"      sweetberry-modifier: 10\n" + 
		"      kelp-modifier: 10\n" + 
		"    entity-activation-range:\n" + 
		"      water: 8\n" + 
		"      animals: 16\n" + 
		"      monsters: 16\n" + 
		"      raiders: 24\n" + 
		"      misc: 8\n" + 
		"      tick-inactive-villagers: false\n" + 
		"    merge-radius:\n" + 
		"      exp: 10.0\n" + 
		"      item: 5\n" + 
		"    entity-tracking-range:\n" + 
		"      players: 24\n" + 
		"      animals: 24\n" + 
		"      monsters: 24\n" + 
		"      misc: 16\n" + 
		"      other: 32\n" + 
		"    ticks-per:\n" + 
		"      hopper-transfer: 16\n" + 
		"      hopper-check: 4\n" + 
		"    hunger:\n" + 
		"      jump-walk-exhaustion: 0.05\n" + 
		"      jump-sprint-exhaustion: 0.2\n" + 
		"      combat-exhaustion: 0.1\n" + 
		"      regen-exhaustion: 6.0\n" + 
		"      swim-multiplier: 0.01\n" + 
		"      sprint-multiplier: 0.1\n" + 
		"      other-multiplier: 0.0\n" + 
		"    max-tick-time:\n" + 
		"      tile: 200\n" + 
		"      entity: 200\n" + 
		"    squid-spawn-range:\n" + 
		"      min: 45.0";

public static String paper = "# This is the main configuration file for Paper.\n" + 
		"# As you can see, there's tons to configure. Some options may impact gameplay, so use\n" + 
		"# with caution, and make sure you know what each option does before configuring.\n" + 
		"# \n" + 
		"# If you need help with the configuration or have any questions related to Paper,\n" + 
		"# join us in our Discord or IRC channel.\n" + 
		"# \n" + 
		"# Discord: https://paperdiscord.emc.gs\n" + 
		"# IRC: #paper @ irc.spi.gt ( http://irc.spi.gt/iris/?channels=paper )\n" + 
		"# Website: https://papermc.io/ \n" + 
		"# Docs: https://paper.readthedocs.org/ \n" + 
		"\n" + 
		"verbose: false\n" + 
		"config-version: 20\n" + 
		"settings:\n" + 
		"  load-permissions-yml-before-plugins: true\n" + 
		"  bungee-online-mode: true\n" + 
		"  region-file-cache-size: 256\n" + 
		"  incoming-packet-spam-threshold: 300\n" + 
		"  use-alternative-luck-formula: false\n" + 
		"  save-player-data: true\n" + 
		"  suggest-player-names-when-null-tab-completions: true\n" + 
		"  enable-player-collisions: true\n" + 
		"  save-empty-scoreboard-teams: false\n" + 
		"  velocity-support:\n" + 
		"    enabled: false\n" + 
		"    online-mode: false\n" + 
		"    secret: ''\n" + 
		"  async-chunks:\n" + 
		"    enable: true\n" + 
		"    load-threads: -1\n" + 
		"  watchdog:\n" + 
		"    early-warning-every: 5000\n" + 
		"    early-warning-delay: 10000\n" + 
		"  spam-limiter:\n" + 
		"    tab-spam-increment: 1\n" + 
		"    tab-spam-limit: 500\n" + 
		"  book-size:\n" + 
		"    page-max: 2560\n" + 
		"    total-multiplier: 0.98\n" + 
		"messages:\n" + 
		"  no-permission: '&cI''m sorry, but you do not have permission to perform this command.\n" + 
		"    Please contact the server administrators if you believe that this is in error.'\n" + 
		"  kick:\n" + 
		"    authentication-servers-down: ''\n" + 
		"    connection-throttle: Connection throttled! Please wait before reconnecting.\n" + 
		"    flying-player: Flying is not enabled on this server\n" + 
		"    flying-vehicle: Flying is not enabled on this server\n" + 
		"timings:\n" + 
		"  enabled: true\n" + 
		"  verbose: true\n" + 
		"  server-name-privacy: false\n" + 
		"  hidden-config-entries:\n" + 
		"  - database\n" + 
		"  - settings.bungeecord-addresses\n" + 
		"  history-interval: 300\n" + 
		"  history-length: 3600\n" + 
		"  server-name: Mapmaking Megaserver\n" + 
		"world-settings:\n" + 
		"  default:\n" + 
		"    fixed-chunk-inhabited-time: -1\n" + 
		"    optimize-explosions: true\n" + 
		"    use-vanilla-world-scoreboard-name-coloring: false\n" + 
		"    enable-treasure-maps: true\n" + 
		"    treasure-maps-return-already-discovered: false\n" + 
		"    prevent-moving-into-unloaded-chunks: false\n" + 
		"    disable-teleportation-suffocation-check: false\n" + 
		"    experience-merge-max-value: -1\n" + 
		"    max-auto-save-chunks-per-tick: 24\n" + 
		"    per-player-mob-spawns: false\n" + 
		"    remove-corrupt-tile-entities: false\n" + 
		"    filter-nbt-data-from-spawn-eggs-and-related: true\n" + 
		"    max-entity-collisions: 4\n" + 
		"    disable-creeper-lingering-effect: false\n" + 
		"    duplicate-uuid-resolver: saferegen\n" + 
		"    duplicate-uuid-saferegen-delete-range: 32\n" + 
		"    falling-block-height-nerf: 0\n" + 
		"    tnt-entity-height-nerf: 0\n" + 
		"    disable-thunder: false\n" + 
		"    skeleton-horse-thunder-spawn-chance: 0.01\n" + 
		"    disable-ice-and-snow: false\n" + 
		"    keep-spawn-loaded-range: 10\n" + 
		"    keep-spawn-loaded: true\n" + 
		"    auto-save-interval: -1\n" + 
		"    armor-stands-do-collision-entity-lookups: true\n" + 
		"    count-all-mobs-for-spawning: false\n" + 
		"    seed-based-feature-search: true\n" + 
		"    nether-ceiling-void-damage-height: 0\n" + 
		"    water-over-lava-flow-speed: 5\n" + 
		"    grass-spread-tick-rate: 1\n" + 
		"    bed-search-radius: 1\n" + 
		"    use-faster-eigencraft-redstone: true\n" + 
		"    fix-zero-tick-instant-grow-farms: true\n" + 
		"    allow-non-player-entities-on-scoreboards: false\n" + 
		"    portal-search-radius: 128\n" + 
		"    portal-create-radius: 16\n" + 
		"    disable-explosion-knockback: false\n" + 
		"    container-update-tick-rate: 1\n" + 
		"    parrots-are-unaffected-by-player-movement: false\n" + 
		"    non-player-arrow-despawn-rate: -1\n" + 
		"    creative-arrow-despawn-rate: -1\n" + 
		"    prevent-tnt-from-moving-in-water: false\n" + 
		"    iron-golems-can-spawn-in-air: false\n" + 
		"    armor-stands-tick: true\n" + 
		"    entities-target-with-follow-range: false\n" + 
		"    spawner-nerfed-mobs-should-jump: false\n" + 
		"    baby-zombie-movement-modifier: 0.5\n" + 
		"    zombie-villager-infection-chance: -1.0\n" + 
		"    allow-leashing-undead-horse: false\n" + 
		"    all-chunks-are-slime-chunks: false\n" + 
		"    mob-spawner-tick-rate: 1\n" + 
		"    game-mechanics:\n" + 
		"      scan-for-legacy-ender-dragon: true\n" + 
		"      disable-pillager-patrols: false\n" + 
		"      disable-unloaded-chunk-enderpearl-exploit: true\n" + 
		"      nerf-pigmen-from-nether-portals: false\n" + 
		"      disable-chest-cat-detection: false\n" + 
		"      shield-blocking-delay: 5\n" + 
		"      disable-end-credits: false\n" + 
		"      disable-player-crits: false\n" + 
		"      disable-sprint-interruption-on-attack: false\n" + 
		"      disable-relative-projectile-velocity: false\n" + 
		"    lightning-strike-distance-limit:\n" + 
		"      sound: -1\n" + 
		"      impact-sound: -1\n" + 
		"      flash: -1\n" + 
		"    frosted-ice:\n" + 
		"      enabled: true\n" + 
		"      delay:\n" + 
		"        min: 20\n" + 
		"        max: 40\n" + 
		"    lootables:\n" + 
		"      auto-replenish: false\n" + 
		"      restrict-player-reloot: true\n" + 
		"      reset-seed-on-fill: true\n" + 
		"      max-refills: -1\n" + 
		"      refresh-min: 12h\n" + 
		"      refresh-max: 2d\n" + 
		"    max-growth-height:\n" + 
		"      cactus: 3\n" + 
		"      reeds: 3\n" + 
		"    alt-item-despawn-rate:\n" + 
		"      enabled: false\n" + 
		"      items:\n" + 
		"        COBBLESTONE: 300\n" + 
		"    hopper:\n" + 
		"      cooldown-when-full: true\n" + 
		"      disable-move-event: false\n" + 
		"    fishing-time-range:\n" + 
		"      MinimumTicks: 100\n" + 
		"      MaximumTicks: 600\n" + 
		"    despawn-ranges:\n" + 
		"      soft: 32\n" + 
		"      hard: 128\n" + 
		"    squid-spawn-height:\n" + 
		"      maximum: 0.0\n" + 
		"    anti-xray:\n" + 
		"      enabled: false\n" + 
		"      engine-mode: 1\n" + 
		"      chunk-edge-mode: 2\n" + 
		"      max-chunk-section-index: 3\n" + 
		"      update-radius: 2\n" + 
		"      hidden-blocks:\n" + 
		"      - gold_ore\n" + 
		"      - iron_ore\n" + 
		"      - coal_ore\n" + 
		"      - lapis_ore\n" + 
		"      - mossy_cobblestone\n" + 
		"      - obsidian\n" + 
		"      - chest\n" + 
		"      - diamond_ore\n" + 
		"      - redstone_ore\n" + 
		"      - clay\n" + 
		"      - emerald_ore\n" + 
		"      - ender_chest\n" + 
		"      replacement-blocks:\n" + 
		"      - stone\n" + 
		"      - oak_planks\n" + 
		"    generator-settings:\n" + 
		"      flat-bedrock: false";
}
