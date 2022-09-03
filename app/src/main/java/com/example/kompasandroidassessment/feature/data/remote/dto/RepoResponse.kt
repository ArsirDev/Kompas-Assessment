package com.example.kompasandroidassessment.feature.data.remote.dto

import com.google.gson.annotations.SerializedName

data class RepoResponse(

	@SerializedName("RepoResponse")
	val repoResponse: List<RepoResponseItem>
)

data class RepoResponseItem(

	@SerializedName("allow_forking")
	val allowForking: Boolean,

	@SerializedName("stargazers_count")
	val stargazersCount: Int,

	@SerializedName("is_template")
	val isTemplate: Boolean,

	@SerializedName("pushed_at")
	val pushedAt: String,

	@SerializedName("subscription_url")
	val subscriptionUrl: String,

	@SerializedName("language")
	val language: String,

	@SerializedName("branches_url")
	val branchesUrl: String,

	@SerializedName("issue_comment_url")
	val issueCommentUrl: String,

	@SerializedName("labels_url")
	val labelsUrl: String,

	@SerializedName("subscribers_url")
	val subscribersUrl: String,

	@SerializedName("releases_url")
	val releasesUrl: String,

	@SerializedName("svn_url")
	val svnUrl: String,

	@SerializedName("id")
	val id: Int,

	@SerializedName("forks")
	val forks: Int,

	@SerializedName("archive_url")
	val archiveUrl: String,

	@SerializedName("git_refs_url")
	val gitRefsUrl: String,

	@SerializedName("forks_url")
	val forksUrl: String,

	@SerializedName("visibility")
	val visibility: String,

	@SerializedName("statuses_url")
	val statusesUrl: String,

	@SerializedName("ssh_url")
	val sshUrl: String,

	@SerializedName("license")
	val license: License,

	@SerializedName("full_name")
	val fullName: String,

	@SerializedName("size")
	val size: Int,

	@SerializedName("languages_url")
	val languagesUrl: String,

	@SerializedName("html_url")
	val htmlUrl: String,

	@SerializedName("collaborators_url")
	val collaboratorsUrl: String,

	@SerializedName("clone_url")
	val cloneUrl: String,

	@SerializedName("name")
	val name: String,

	@SerializedName("pulls_url")
	val pullsUrl: String,

	@SerializedName("default_branch")
	val defaultBranch: String,

	@SerializedName("hooks_url")
	val hooksUrl: String,

	@SerializedName("trees_url")
	val treesUrl: String,

	@SerializedName("tags_url")
	val tagsUrl: String,

	@SerializedName("private")
	val jsonMemberPrivate: Boolean,

	@SerializedName("contributors_url")
	val contributorsUrl: String,

	@SerializedName("has_downloads")
	val hasDownloads: Boolean,

	@SerializedName("notifications_url")
	val notificationsUrl: String,

	@SerializedName("open_issues_count")
	val openIssuesCount: Int,

	@SerializedName("description")
	val description: String,

	@SerializedName("created_at")
	val createdAt: String,

	@SerializedName("watchers")
	val watchers: Int,

	@SerializedName("keys_url")
	val keysUrl: String,

	@SerializedName("deployments_url")
	val deploymentsUrl: String,

	@SerializedName("has_projects")
	val hasProjects: Boolean,

	@SerializedName("archived")
	val archived: Boolean,

	@SerializedName("has_wiki")
	val hasWiki: Boolean,

	@SerializedName("updated_at")
	val updatedAt: String,

	@SerializedName("comments_url")
	val commentsUrl: String,

	@SerializedName("stargazers_url")
	val stargazersUrl: String,

	@SerializedName("disabled")
	val disabled: Boolean,

	@SerializedName("git_url")
	val gitUrl: String,

	@SerializedName("has_pages")
	val hasPages: Boolean,

	@SerializedName("owner")
	val owner: Owner,

	@SerializedName("commits_url")
	val commitsUrl: String,

	@SerializedName("compare_url")
	val compareUrl: String,

	@SerializedName("git_commits_url")
	val gitCommitsUrl: String,

	@SerializedName("topics")
	val topics: List<Any>,

	@SerializedName("blobs_url")
	val blobsUrl: String,

	@SerializedName("git_tags_url")
	val gitTagsUrl: String,

	@SerializedName("merges_url")
	val mergesUrl: String,

	@SerializedName("downloads_url")
	val downloadsUrl: String,

	@SerializedName("has_issues")
	val hasIssues: Boolean,

	@SerializedName("web_commit_signoff_required")
	val webCommitSignoffRequired: Boolean,

	@SerializedName("url")
	val url: String,

	@SerializedName("contents_url")
	val contentsUrl: String,

	@SerializedName("mirror_url")
	val mirrorUrl: Any,

	@SerializedName("milestones_url")
	val milestonesUrl: String,

	@SerializedName("teams_url")
	val teamsUrl: String,

	@SerializedName("fork")
	val fork: Boolean,

	@SerializedName("issues_url")
	val issuesUrl: String,

	@SerializedName("events_url")
	val eventsUrl: String,

	@SerializedName("issue_events_url")
	val issueEventsUrl: String,

	@SerializedName("assignees_url")
	val assigneesUrl: String,

	@SerializedName("open_issues")
	val openIssues: Int,

	@SerializedName("watchers_count")
	val watchersCount: Int,

	@SerializedName("node_id")
	val nodeId: String,

	@SerializedName("homepage")
	val homepage: String,

	@SerializedName("forks_count")
	val forksCount: Int
)

data class Owner(

	@SerializedName("gists_url")
	val gistsUrl: String,

	@SerializedName("repos_url")
	val reposUrl: String,

	@SerializedName("following_url")
	val followingUrl: String,

	@SerializedName("starred_url")
	val starredUrl: String,

	@SerializedName("login")
	val login: String,

	@SerializedName("followers_url")
	val followersUrl: String,

	@SerializedName("type")
	val type: String,

	@SerializedName("url")
	val url: String,

	@SerializedName("subscriptions_url")
	val subscriptionsUrl: String,

	@SerializedName("received_events_url")
	val receivedEventsUrl: String,

	@SerializedName("avatar_url")
	val avatarUrl: String,

	@SerializedName("events_url")
	val eventsUrl: String,

	@SerializedName("html_url")
	val htmlUrl: String,

	@SerializedName("site_admin")
	val siteAdmin: Boolean,

	@SerializedName("id")
	val id: Int,

	@SerializedName("gravatar_id")
	val gravatarId: String,

	@SerializedName("node_id")
	val nodeId: String,

	@SerializedName("organizations_url")
	val organizationsUrl: String
)

data class License(

	@SerializedName("name")
	val name: String,

	@SerializedName("spdx_id")
	val spdxId: String,

	@SerializedName("key")
	val key: String,

	@SerializedName("url")
	val url: String,

	@SerializedName("node_id")
	val nodeId: String
)
